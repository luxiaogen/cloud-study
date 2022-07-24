package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 陆小根
 * date: 2022/07/24
 * Description:
 */

@Configuration
public class ApplicationContextConfig {

  // 注入 RestTemplate
  @Bean
  @LoadBalanced // 开启负载均衡  不然注册中心会不知道找哪个提供者的地址
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
