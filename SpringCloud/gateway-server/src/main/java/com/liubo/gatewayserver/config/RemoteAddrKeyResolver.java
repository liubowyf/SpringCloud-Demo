package com.liubo.gatewayserver.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassNameRemoteAddrKeyResolver
 * @Description 限流配置
 * @Author liubo
 * @Date 2020/6/30 15:49
 */
public class RemoteAddrKeyResolver implements KeyResolver {
	public static final String BEAN_NAME = "remoteAddrKeyResolver";

	@Override
	public Mono<String> resolve(ServerWebExchange serverWebExchange) {
		return Mono.just(serverWebExchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	}
}
