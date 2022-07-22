package com.atguigu.springcloud.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 */

// 假设出事了 后面 fallback 的类来处理
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixClient {

  @GetMapping("/payment/hystrix/ok/{id}")
  public String paymentInfo_OK(@PathVariable("id") Integer id);

  @GetMapping("/payment/hystrix/timeout/{id}")
  public String paymentInfo_TIMEOUT(@PathVariable("id") Integer id);

}
