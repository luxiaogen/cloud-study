package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 陆小根
 * date: 2022/07/21
 * Description:
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderZKMain80.class,args);
  }

}
