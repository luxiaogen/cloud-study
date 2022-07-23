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
@RefreshScope // 开启自动刷新功能
public class ConfigClientController {

  @Value("${server.port}")
  public String serverPort;

  @Value("${config.info}")
  public String configInfo;

  @GetMapping("/configInfo")
  public String configInfo() {
    return "port：" + serverPort + "\t\n\n  configInfo" + configInfo;
  }

}
