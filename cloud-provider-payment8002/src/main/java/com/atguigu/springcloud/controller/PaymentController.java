package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.feignclient.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

  @Value("${server.port}")
  public String serverPort;

  @Autowired
  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
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

  @GetMapping("/lb")
  public String getServerPort() {
    return serverPort;
  }

}
