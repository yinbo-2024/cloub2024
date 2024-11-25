package com.atguigu.cloub.mygateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 *  自定义 配置 单一 过滤器 不能设置参数
 */
@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config>{

    public static final String NAME = "name";

    public MyGatewayFilterFactory() {
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpRequest serverHttpRequest = exchange.getRequest();
                System.out.println("自定义过滤器 单一 filter  状态值:" +config.getName());
                if(serverHttpRequest.getQueryParams().containsKey("YinBo")){
                    return chain.filter(exchange);
                } else{
                    exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                    return exchange.getResponse().setComplete();
                }
            }
        };
    }

    /**
     * 短格式 支持
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(NAME);
    }


    @Validated
    public static class Config {

        @NotNull
        private String  name;

        public @NotNull String getName() {
            return name;
        }

        public void setName(@NotNull String name) {
            this.name = name;
        }

    }
}
