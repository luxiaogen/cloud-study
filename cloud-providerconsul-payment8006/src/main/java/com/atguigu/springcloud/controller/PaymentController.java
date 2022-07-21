package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 陆小根
 * date: 2022/07/21
 * Description:
 */

@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Value("${server.port}")
  public String serverPort;

  @RequestMapping("/consul")
  public String paymentInfo() {
    return "spring-cloud with consul: " + serverPort + " \t " + UUID.randomUUID().toString();
  }

}
