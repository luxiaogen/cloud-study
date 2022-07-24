package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陆小根
 * date: 2022/07/24
 * Description:
 */

@RestController
@RequestMapping("/payment/nacos")
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("/{id}")
  public String getPayment(@PathVariable("id") Integer id) {
    return "nacos registry, serverPort: " + serverPort + "\t" + "id:" + id;
  }

}
