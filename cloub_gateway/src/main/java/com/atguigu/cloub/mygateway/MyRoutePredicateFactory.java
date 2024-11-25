package com.atguigu.cloub.mygateway;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;


/**
 * 自定义 gateway 路由断言
 */
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    public static final String USER_TYPE = "userType";


    public MyRoutePredicateFactory (){
        super(MyRoutePredicateFactory.Config.class);
    }

    /**
     *  短格式 支持
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(USER_TYPE);
    }

    /**
     * 访问路径 后缀有 userType
     * @param config
     * @return
     */
    @Override
    public Predicate<ServerWebExchange> apply(MyRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String userType=serverWebExchange.getRequest().getQueryParams().getFirst("userType");
                if(userType==null){
                    return false;
                }
                if(userType.equalsIgnoreCase(config.getUserType())){
                    return  true;
                }
                return false;
            }
        };
    }


    @Validated
    public static class Config {


        @NotNull
        private String  userType;

        public @NotNull String getUserType() {
            return userType;
        }

        public void setUserType(@NotNull String userType) {
            this.userType = userType;
        }




    }

}
