package com.atguigu.springcloud.feignclients;

import org.springframework.stereotype.Component;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixClient {


  @Override
  public String paymentInfo_OK(Integer id) {
    String str = "PaymentFallbackService fall back-paymentInfo_OK，o(╥﹏╥)o";
    return str;
  }

  @Override
  public String paymentInfo_TIMEOUT(Integer id) {
    String str = "PaymentFallbackService fall paymentInfo_TIMEOUT，o(╥﹏╥)o";
    return str;
  }
}
