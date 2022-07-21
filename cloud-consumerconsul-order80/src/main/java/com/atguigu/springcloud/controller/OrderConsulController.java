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
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderConsulController {

  public static final String INVOKE_URL = "http://consul-provider-payment";

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping("/consul")
  public String paymentInfo() {
    return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
  }

}
