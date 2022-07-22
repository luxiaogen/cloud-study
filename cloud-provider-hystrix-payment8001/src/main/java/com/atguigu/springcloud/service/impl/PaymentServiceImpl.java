package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 */

@Service
public class PaymentServiceImpl implements PaymentService {

  @Override
  public String paymentInfo_OK(Integer id) {
    return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_OK,id:" + id + "\t" + "^_^";
  }

  @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") // 也就是 3 秒之后就是要开始兜底了
  })
  @Override
  public String paymentInfo_TIMEOUT(Integer id) {
    int timeNumber = 3;
    try {
      // 睡眠3秒
      TimeUnit.SECONDS.sleep(timeNumber);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "线程池：" + Thread.currentThread().getName() + "paymentInfo_TIMEOUT,id:" + id + "\t" + "^_^" + "耗时(s):" + timeNumber;
  }

  public String paymentInfo_TimeoutHandler(Integer id) {
    return "线程池：" + Thread.currentThread().getName() + " 系统繁忙或者运行报错，请稍后再试，id: " + id + "\t" + "o(╥﹏╥)o";
  }

  // === 服务熔断
  @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
          @HystrixProperty(name = "circuitBreaker.enabled", value= "true"), // 是否开启断路器
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="10"), // 请求次数
          @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="1000"), // 时间范围
          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60") // 失败率达到多少后跳闸
  })
  public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
    if (id < 0) {
      throw new RuntimeException("*** id 不能为负数");
    }
    String serialNumber = IdUtil.simpleUUID(); // Hutool工具类

    return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
  }

  public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
    return "id 不能为负数，请稍后再试，o(╥﹏╥)o，id：" + id;
  }

}