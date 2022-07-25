package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 陆小根
 * date: 2022/07/25
 * Description:
 */

@EnableDiscoveryClient // 开启服务发现
@SpringBootApplication
public class NacosConfigClientMain3377 {

  public static void main(String[] args) {
    SpringApplication.run(NacosConfigClientMain3377.class, args);
  }

}
