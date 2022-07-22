package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 */

@SpringBootApplication
@EnableEurekaClient // 开启Eureka客户端
@EnableCircuitBreaker // 开启对 @HystrixCommand注解的支持
public class PaymentHystrixMain8001 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentHystrixMain8001.class, args);
  }

}
