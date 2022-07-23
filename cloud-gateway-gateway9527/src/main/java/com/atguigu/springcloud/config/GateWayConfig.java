package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陆小根
 * date: 2022/07/23
 * Description:
 *
 * 网关路由的第二种配置方式 注入 Bean方式
 */

@Configuration
public class GateWayConfig {

  /**
   * 配置了一个id为route-name的路由规则
   * 当访问地址 http://localhost:9527/guenei 时会自动转发到地址 http://news.baidu.com/guonei
   * @param builder
   * @return
   */
  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    RouteLocatorBuilder.Builder routes = builder.routes();

    routes.route("path_route_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com/guenei")).build();
    return routes.build();
  }

  @Bean
  public RouteLocator customRouterLocator2(RouteLocatorBuilder builder) {
    RouteLocatorBuilder.Builder routes = builder.routes();

    routes.route("path_route_atguigu", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
    return routes.build();
  }



}
