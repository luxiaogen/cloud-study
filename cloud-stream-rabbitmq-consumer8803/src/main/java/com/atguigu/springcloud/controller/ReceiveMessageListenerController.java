package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author 陆小根
 * date: 2022/07/24
 * Description:
 */

@Component
@Slf4j
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

  @Value("${server.port}")
  private String serverPort;

  @StreamListener(Sink.INPUT)
  public void input(Message<String> message) {
    log.info("消费者2 ---> 接收到的消息："  + message.getPayload() + "\t port ---> " + serverPort);
  }

}
