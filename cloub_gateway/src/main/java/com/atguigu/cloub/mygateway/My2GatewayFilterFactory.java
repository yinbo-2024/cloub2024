package com.atguigu.cloub.mygateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


import static org.springframework.cloud.gateway.support.GatewayToStringStyler.filterToStringCreator;

/**
 * 自定义 配置 单一 过滤器  可设置参数
 */
@Component
public class My2GatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpRequest serverHttpRequest = exchange.getRequest();
                System.out.println("自定义过滤器 单一 filter  key:" + config.getName() + "\t" + "value:" + config.getValue());
                MultiValueMap<String, String> QueryParams = serverHttpRequest.getQueryParams();
                String mulValue = QueryParams.containsKey(config.getName()) ? QueryParams.getFirst(config.getName()) : null;
                if (QueryParams.containsKey(config.getName()) && mulValue.equalsIgnoreCase(config.getValue())) {
                    return chain.filter(exchange);
                } else {
                    exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                    return exchange.getResponse().setComplete();
                }
            }

            @Override
            public String toString() {
                return filterToStringCreator(My2GatewayFilterFactory.this)
                        .append(config.getName(), config.getValue()).toString();
            }
        };
    }
}
