package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
@RequestMapping("/payment/hystrix")
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  private PaymentService paymentService;

  @Autowired
  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @GetMapping("/ok/{id}")
  public String paymentInfo_OK(@PathVariable("id") Integer id) {
    String result = paymentService.paymentInfo_OK(id);
    log.info("****${}****", result);
    return result;
  }

  @GetMapping("/timeout/{id}")
  public String paymentInfo_TIMEOUT(@PathVariable("id") Integer id) {
    String result = paymentService.paymentInfo_TIMEOUT(id);
    log.info("****${}****", result);
    return result;
  }

  // == 服务熔断
  @GetMapping("/circuit/{id}")
  public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
    String result = paymentService.paymentCircuitBreaker(id);
    log.info("***" + result);
    return result;
  }
}
