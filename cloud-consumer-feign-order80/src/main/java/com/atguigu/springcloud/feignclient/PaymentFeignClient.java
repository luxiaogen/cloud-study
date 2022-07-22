package com.atguigu.springcloud.feignclient;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 */
@FeignClient("CLOUD-PAYMENT-SERVICE") // 开启并使用open-feign客户端
public interface PaymentFeignClient {

  @GetMapping("/payment/{id}")
  CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

  // 测试 feign客户端的超时时长
  @GetMapping("/payment/feign/timeout")
  String feignTimeout();
}
