package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 *
 * Spring配置文件
 */

@Configuration
public class ApplicationContextConfig {

  // 需要提前注入 默认没有
  @Bean
  // @LoadBalanced // 开启负载均衡 不然内部不知道访问谁
  // 注释掉 开始手写轮询底层
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
