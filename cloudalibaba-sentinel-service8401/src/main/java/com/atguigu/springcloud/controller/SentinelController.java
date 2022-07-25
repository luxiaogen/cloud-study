package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陆小根
 * date: 2022/07/25
 * Description:
 */

@RestController
@Slf4j
public class SentinelController {

  @GetMapping("/testA")
  public String testA() {
    return "----testA";
  }

  @GetMapping("/testB")
  public String testB() {
    log.info(Thread.currentThread().getName() + "\t" + "testB");
    return "----testB";
  }

}
