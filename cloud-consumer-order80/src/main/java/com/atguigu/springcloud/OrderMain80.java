package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@SpringBootApplication
@EnableEurekaClient // 注册为客户端
public class OrderMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderMain80.class,args);
  }

}
