package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.pojo.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@SpringBootTest
public class PaymentDaoTest {

  @Autowired
  private PaymentDao paymentDao;

  @Test
  void testGetById() {
    Payment payment = paymentDao.getPaymentById(31L);
    System.out.println(payment);
  }
}
