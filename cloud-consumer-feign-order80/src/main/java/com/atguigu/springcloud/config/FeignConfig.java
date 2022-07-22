package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 *
 * Feign 客户端的日志功能
 */

@Configuration
public class FeignConfig {

  @Bean
  public Logger.Level level() {
    return Logger.Level.FULL;
  }

}
