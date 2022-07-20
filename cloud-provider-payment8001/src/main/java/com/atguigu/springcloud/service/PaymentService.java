package com.atguigu.springcloud.service;

import com.atguigu.springcloud.pojo.Payment;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

public interface PaymentService {

  /**
   * 插入一条数据
   * @param payment
   * @return
   */
  public int create(Payment payment);

  /**
   * 根据id查找
   * @param id
   * @return
   */
  public Payment getPaymentById(Long id);

}

