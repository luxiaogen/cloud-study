package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陆小根
 * date: 2022/07/23
 * Description:
 */

@RestController
@RefreshScope // 开启自动配置的自动刷新 但是需要通过curl发送一个post请求才能实时更新
public class ConfigClientController {

  @Value("${config.info}")
  public String configInfo;

  @GetMapping("/configInfo")
  public String getConfigInfo() {
    return configInfo;
  }

}
