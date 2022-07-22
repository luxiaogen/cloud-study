package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 */

public interface PaymentService {

  /**
   * 正常访问
   * @param id
   * @return
   */
  public String paymentInfo_OK(Integer id);


  /**
   * 超时访问
   * @param id
   * @return
   */
  public String paymentInfo_TIMEOUT(Integer id);

  /**
   * 服务熔断测试
   * @param id
   * @return
   */
  public String paymentCircuitBreaker(@PathVariable("id") Integer id);

}
