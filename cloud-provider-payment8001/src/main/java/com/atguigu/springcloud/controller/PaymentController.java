package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping("/create")
  public CommonResult create(@RequestBody Payment payment) {
    int result = paymentService.create(payment);
    log.info("***插入结果${}****", result);

    if (result > 0) {
      return new CommonResult(200, "插入数据库成功", result);
    } else {
      return new CommonResult(444, "插入数据失败");
    }
  }

  @GetMapping("/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("****查找结果${}***", payment);

    if (payment != null) {
      return new CommonResult<Payment>(200, "查询成功", payment);
    } else {
      return new CommonResult<Payment>(444, "没有对应的记录，查询ID" + id);
    }
  }

}
