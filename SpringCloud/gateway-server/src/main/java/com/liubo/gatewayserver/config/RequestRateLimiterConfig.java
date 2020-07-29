package com.liubo.gatewayserver.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ：liubo
 * @date ：Created in 2020/7/27 16:29
 * @description：限流
 */
@Configuration
public class RequestRateLimiterConfig {
  @Bean
  public KeyResolver apiKeyResolver() {
    // 按URL限流,即以每秒内请求数按URL分组统计，超出限流的url请求都将返回429状态
    return exchange -> Mono.just(exchange.getRequest().getPath().toString());
  }

  @Bean
  public KeyResolver userKeyResolver() {
    // 按用户限流
    return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
  }

  @Bean(value = "ipKeyResolver")
  @Primary
  public KeyResolver ipKeyResolver() {
    // 按IP来限流
    return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
  }
}
