package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 陆小根
 * date: 2022/07/24
 * Description:
 */

@RestController
@RequestMapping("/consumer/payment/nacos")
public class OrderNacosController {

  private RestTemplate restTemplate;

  @Value("${server-url.nacos-user-service}")
  public String serverURL;

  @Autowired
  public OrderNacosController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping("/{id}")
  public String paymentInfo(@PathVariable("id") Integer id) {
    return restTemplate.getForObject(serverURL + "/payment/nacos/" + id, String.class);
  }
}
