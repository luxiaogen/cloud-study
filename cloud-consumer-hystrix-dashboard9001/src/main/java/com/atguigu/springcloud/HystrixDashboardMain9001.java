package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 陆小根
 * date: 2022/07/23
 * Description:
 */

@SpringBootApplication
//@EnableCircuitBreaker
@EnableHystrixDashboard // 开启对服务监控 hystrixdashboard的启动
public class HystrixDashboardMain9001 {

  public static void main(String[] args) {
    SpringApplication.run(HystrixDashboardMain9001.class, args);
  }

}
