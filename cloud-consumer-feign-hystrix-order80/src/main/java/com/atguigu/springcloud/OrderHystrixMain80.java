package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 */

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker // 开启对 @HystrixCommand 注解的支持
public class OrderHystrixMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderHystrixMain80.class, args);
  }

}
