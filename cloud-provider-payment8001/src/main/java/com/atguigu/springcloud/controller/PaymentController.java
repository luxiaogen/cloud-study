package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.feignclient.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

  private PaymentService paymentService;

  private DiscoveryClient discoveryClient;


  @Value("${server.port}")
  public String serverPort;

  @Autowired
  public PaymentController(PaymentService paymentService,DiscoveryClient discoveryClient) {
    this.paymentService = paymentService;
    this.discoveryClient = discoveryClient;
  }

  @PostMapping("/create")
  public CommonResult create(@RequestBody Payment payment) {
    int result = paymentService.create(payment);

    if (result > 0) {
      return new CommonResult(200, "插入数据库成功" + serverPort, result);
    } else {
      return new CommonResult(444, "插入数据失败");
    }
  }

  @GetMapping("/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
    Payment payment = paymentService.getPaymentById(id);

    if (payment != null) {
      return new CommonResult<Payment>(200, "查询成功" + serverPort, payment);
    } else {
      return new CommonResult<Payment>(444, "没有对应的记录，查询ID" + id);
    }
  }

  @GetMapping("/discovery")
  public Object discovery() {
    List<String> services = discoveryClient.getServices();
    for (String service : services) {
      log.info("****${}***", service);
    }
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    for (ServiceInstance instance : instances) {
      log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
    }
    return this.discoveryClient;
  }

  @GetMapping("/lb")
  public String getServerPort() {
    return serverPort;
  }

  @GetMapping("/feign/timeout")
  public String feignTimeout() {
    // 睡眠3秒
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "Hello~，Feign";
  }


  @GetMapping("/zipkin")
  public String paymentZipkin() {
    return "h1, i'am paymentzipkin server fall back, welcome to atguigu, ^_^";
  }

}
