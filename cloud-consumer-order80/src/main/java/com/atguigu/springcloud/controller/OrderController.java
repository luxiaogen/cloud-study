package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

  public static final String PAYMENT_URL = "http://localhost:8001";

  /**
   * RestTemplate提供了多种便捷访问远程Http服务的方法
   * 是一种简单编辑的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
   * <p>
   * 使用：
   * - url Rest请求地址
   * - requestMap 请求参数
   * - ResponseBean.class  Http响应转换被转换后的对象类型
   */
  private RestTemplate restTemplate;

  @Autowired
  public OrderController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


  @GetMapping("/create")
  public CommonResult<Payment> create(Payment payment) {
    log.info("---consumer${}---",payment);
    return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
  }

  @GetMapping("/{id}")
  public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
    log.info("---consumer${}---",id);
    return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
  }

}
