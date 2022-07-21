package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 陆小根
 * date: 2022/07/21
 * Description:
 */

@Configuration
public class ApplicationContextConfig {

  @Bean
  @LoadBalanced // 开启负载均衡不然会报错
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
