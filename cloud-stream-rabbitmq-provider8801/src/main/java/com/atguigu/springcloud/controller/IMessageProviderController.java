package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陆小根
 * date: 2022/07/24
 * Description:
 */

@RestController
public class IMessageProviderController {

  @Autowired
  private IMessageProvider messageProvider;

  @GetMapping("/sendMessage")
  public String send() {
    return messageProvider.send();
  }

}
