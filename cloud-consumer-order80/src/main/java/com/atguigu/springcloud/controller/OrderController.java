package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.lb.LoadBalancer;
import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

//  public static final String PAYMENT_URL = "http://localhost:8001";
  // 直接访问注册中心 集群版
  public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

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

  private LoadBalancer loadBalancer;

  private DiscoveryClient discoveryClient;

  @Autowired
  public OrderController(RestTemplate restTemplate, LoadBalancer loadBalancer, DiscoveryClient discoveryClient) {
    this.restTemplate = restTemplate;
    this.loadBalancer = loadBalancer;
    this.discoveryClient = discoveryClient;
  }


  @GetMapping("/create")
  public CommonResult<Payment> create(Payment payment) {
    log.info("---consumer${}---",payment);
    return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
  }

  // 推荐使用这个
  @GetMapping("/{id}")
  public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
    log.info("---consumer${}---",id);
    return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
  }

  // 返回对象为 ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等。
  @GetMapping("/getEntity/{id}")
  public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
    ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, CommonResult.class);
    // 如果成功了
    if (entity.getStatusCode().is2xxSuccessful()) {
      log.info(entity.getStatusCode() + "\t" + entity.getHeaders());
      return entity.getBody(); // 返回请求体
    } else {
      return new CommonResult<>(444, "操作失败");
    }
  }


  @GetMapping("/lb")
  public String getPaymentLB() {
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

    if (instances == null || instances.size() <= 0) {
      return null;
    }
    ServiceInstance serviceInstance = loadBalancer.instances(instances);
    URI uri = serviceInstance.getUri();

    return restTemplate.getForObject(uri + "/payment/lb",String.class);
  }

}
