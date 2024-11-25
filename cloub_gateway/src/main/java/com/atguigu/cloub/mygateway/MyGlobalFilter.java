package com.atguigu.cloub.mygateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义  全局 过滤器  统计 方法 访问时间
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {
    // 请求开始时间
    private static final String BEGIN_VISIT_TIME="begin_visit_time";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // k v
        exchange.getAttributes().put(BEGIN_VISIT_TIME,System.currentTimeMillis());

        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            Long BeginVisitTime=exchange.getAttribute(BEGIN_VISIT_TIME);
            if(BeginVisitTime!=null){
                log.info("访问接口主机："+exchange.getRequest().getURI().getHost());
                log.info("访问接口端口："+exchange.getRequest().getURI().getPort());
                log.info("访问接口路径："+exchange.getRequest().getURI().getPath());
                log.info("访问接口参数："+exchange.getRequest().getURI().getQuery());
                log.info("访问接口时长："+(System.currentTimeMillis()-BeginVisitTime)+" ms");
                log.info("================分割线条=====================");
                System.out.println();

            }
        }));
    }

    /**
     * 数字越小  优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
