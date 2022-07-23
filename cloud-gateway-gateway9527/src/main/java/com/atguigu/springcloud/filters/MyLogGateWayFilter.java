package com.atguigu.springcloud.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author 陆小根
 * date: 2022/07/23
 * Description:
 */

@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("******** come in MyLogGateWayFilter: ${}", new Date());

    String username = exchange.getRequest().getQueryParams().getFirst("username");
    if (username == null) {
      // 拦截请求
      log.info("****用户名为 null，非法用户，o(╥﹏╥)o");
      exchange.getResponse().setStatusCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
      return exchange.getResponse().setComplete();
    }
    // 放行
    return chain.filter(exchange);
  }


  // 执行过滤器的执行顺序
  @Override
  public int getOrder() {
    return 0;
  }
}
