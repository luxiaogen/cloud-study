package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@SpringBootApplication
@EnableEurekaClient // 注册为客户端
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class) // 自定义负载均衡规则 不能放在 ComponentScan下
// 负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务重启后rest接口计数从1开始。
// 1 % 2 = 1 -> index = 1
// 2 % 2 = 0 -> index = 0
// 3 % 2 = 0 -> index = 1
// ...


/**
 * List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")
 * 如 List[0] instances = 127.0.0.1:8002
 *    List[1] instances = 127.0.0.1:8001
 *  8001 + 8002 组成成为集群，集群总数为2，按照轮询算法原理：
 *  当总请求数为1时， 1 % 2 = 1 对应的下标为 1 ，则会哦的服务器地址 127.0.0.1:8001
 *  ....
 */
public class OrderMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderMain80.class,args);
  }

}
