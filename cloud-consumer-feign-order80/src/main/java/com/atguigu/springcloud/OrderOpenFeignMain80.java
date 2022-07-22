package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 */

@SpringBootApplication
@EnableFeignClients // 启动 open-feign 客户端
public class OrderOpenFeignMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderOpenFeignMain80.class, args);
  }

}
