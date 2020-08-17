package com.liubo.gatewayserver.config;

import com.liubo.gatewayserver.exception.ResultExceptionHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.Collections;
import java.util.List;

/**
 * @author ：liubo
 * @date ：Created in 2020/8/17 10:04
 * @description：统一异常处理配置类
 */
@Configuration
public class ExceptionConfig {
    /**
     * 自定义异常处理[@@]注册Bean时依赖的Bean，会从容器中直接获取，所以直接注入即可
     */
    @Primary
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ErrorWebExceptionHandler errorWebExceptionHandler(ObjectProvider<List<ViewResolver>> viewResolversProvider,
                                                             ServerCodecConfigurer serverCodecConfigurer) {
        ResultExceptionHandler resultExceptionHandler = new ResultExceptionHandler();
        resultExceptionHandler.setViewResolvers(viewResolversProvider.getIfAvailable(Collections::emptyList));
        resultExceptionHandler.setMessageWriters(serverCodecConfigurer.getWriters());
        resultExceptionHandler.setMessageReaders(serverCodecConfigurer.getReaders());
        return resultExceptionHandler;
    }
}