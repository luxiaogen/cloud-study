package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@Mapper
public interface PaymentDao {

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
  public Payment getPaymentById(@Param("id") Long id);
}
