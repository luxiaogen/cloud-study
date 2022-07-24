package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author 陆小根
 * date: 2022/07/24
 * Description:
 */

@EnableBinding(Source.class) // 定义消息的推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

  @Autowired
  private MessageChannel output; // 消息发送管道

  @Override
  public String send() {
    String serial = IdUtil.simpleUUID();
    output.send(MessageBuilder.withPayload(serial).build());
    log.info("******${}****", serial);
    return null;
  }
}
