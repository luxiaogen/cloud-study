package com.atguigu.springcloud.feignclient.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.feignclient.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@Service
public class PaymentServiceImpl implements PaymentService {
  private PaymentDao paymentDao;

  @Autowired
  public PaymentServiceImpl(PaymentDao paymentDao) {
    this.paymentDao = paymentDao;
  }



  @Override
  public int create(Payment payment) {
    return paymentDao.create(payment);
  }

  @Override
  public Payment getPaymentById(Long id) {
    return paymentDao.getPaymentById(id);
  }
}
