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
@EnableDiscoveryClient // 该注解用于向使用 consul 或者 zookeeper 作为注册中心时注册服务
public class OrderConsulMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderConsulMain80.class, args);
  }

}
