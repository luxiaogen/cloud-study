package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 陆小根
 * date: 2022/07/24
 * Description:
 */

@SpringBootApplication
@EnableDiscoveryClient // 开启服务发现
public class OrderNacosMain83 {
  public static void main(String[] args) {
    SpringApplication.run(OrderNacosMain83.class, args);
  }
}
