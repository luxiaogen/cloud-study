package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.feignclient.PaymentFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 */

@RestController
@RequestMapping("/consumer/payment")
public class PaymentController {

  @Autowired
  private PaymentFeignClient paymentFeignClient;

  @GetMapping("/{id}")
  public CommonResult<Payment> getById(@PathVariable("id") Long id) {
    return paymentFeignClient.getPaymentById(id);
  }

  @GetMapping("/feign/timeout")
  public String feignTimeout() {
    return paymentFeignClient.feignTimeout();
  }

}
