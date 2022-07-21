package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 陆小根
 * date: 2022/07/21
 * Description:
 */

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderZkController {

  private RestTemplate restTemplate;

  @Autowired
  public OrderZkController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public static final String INVOKE_URL = "http://cloud-provider-payment";

  @RequestMapping("/zk")
  public String paymentInfo() {
    String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    return result;
  }

}
