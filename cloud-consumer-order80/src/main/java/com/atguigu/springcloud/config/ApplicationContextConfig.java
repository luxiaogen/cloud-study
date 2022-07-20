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
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
