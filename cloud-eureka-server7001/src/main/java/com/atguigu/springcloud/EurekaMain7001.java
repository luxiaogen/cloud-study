package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@SpringBootApplication
@EnableEurekaServer // 标识服务中心
public class EurekaMain7001 {

  public static void main(String[] args) {
    SpringApplication.run(EurekaMain7001.class,args);
  }

}
