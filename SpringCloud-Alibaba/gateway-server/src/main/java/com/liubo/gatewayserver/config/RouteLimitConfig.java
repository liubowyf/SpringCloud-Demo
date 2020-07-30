package com.liubo.gatewayserver.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author ：liubo
 * @date ：Created in 2020/7/30 13:31
 * @description：基于Redis的原生限流配置
 */
@Configuration
public class RouteLimitConfig {

    /**
     * 基于ip的限流
     * @author liubo
     * @date 2020/7/30 13:40
     *  * @param
     * @return org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

}
