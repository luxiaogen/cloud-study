package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 陆小根
 * date: 2022/07/22
 * Description:
 *
 * 自定义 负载均衡接口
 */

public interface LoadBalancer {

  ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
