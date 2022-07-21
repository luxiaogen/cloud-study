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
public class SpringApplicationContextConfig {

  @Bean
  @LoadBalanced // !!!!!! 负载均衡 不加 报错
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
