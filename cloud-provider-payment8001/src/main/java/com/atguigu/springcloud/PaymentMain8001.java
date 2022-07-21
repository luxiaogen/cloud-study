package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 开启服务发现
public class PaymentMain8001 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8001.class,args);
  }
  
}
