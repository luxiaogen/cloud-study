package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陆小根
 * date: 2022/07/21
 * Description:
 *
 * 自定义规则
 */
@Configuration
public class MySelfRule {

  @Bean
  public IRule myrule() {
    return new RandomRule(); // 随机
  }

}
