package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 陆小根
 * date: 2022/07/23
 * Description:
 */

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {

  public static void main(String[] args) {
    SpringApplication.run(ConfigClientMain3355.class, args);

  }

}
