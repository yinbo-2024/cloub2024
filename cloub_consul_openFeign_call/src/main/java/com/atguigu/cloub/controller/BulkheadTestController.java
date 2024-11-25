package com.atguigu.cloub.controller;

import com.atguigu.cloub.openFeign.OpenFeignApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class BulkheadTestController {

    @Autowired
    private OpenFeignApi openFeignApi;

//    /**
//     * 舱壁隔离  测试 接口---信号量舱壁
//     * @param id
//     * @return
//     */
//    @RequestMapping("/openFeign/bulkhead/{id}")
//    @Bulkhead(name = "cloub-consul-dao",fallbackMethod="myCircuitBreakBulkheadFallBack",type=Bulkhead.Type.SEMAPHORE)
//    public  String bulkheadTest(@PathVariable("id") String id){
//        return openFeignApi.bulkhead(id);
//    }


//    /**
//     * 舱壁隔离  服务兜底  舱壁隔离兜底方法
//     * @param id
//     * @param throwable
//     * @return
//     */
//    public  String myCircuitBreakBulkheadFallBack(String id,Throwable throwable){
//        return "BreakBulkhead 隔离板超出最大数据限量 请稍后再试 ";
//    }
    /**
     * 舱壁隔离  测试 接口  固定线程池舱壁
     * @param id
     * @return
     */
    @RequestMapping("/openFeign/bulkheadPools/{id}")
    @Bulkhead(name = "cloub-consul-dao",fallbackMethod="myBulkheadFallBack",type=Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> bulkheadTestPool(@PathVariable("id") String id){
        System.out.println("threadName:->"+Thread.currentThread().getName()+" 准备进入");
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
        System.out.println("threadName:->"+Thread.currentThread().getName()+" 准备离开");

        return CompletableFuture.supplyAsync(()->openFeignApi.bulkhead(id));
    }

    /**
     * 舱壁隔离  服务兜底  舱壁隔离兜底方法
     * @param id
     * @param throwable
     * @return
     */
    public CompletableFuture<String> myBulkheadFallBack(String id,Throwable throwable){
        return CompletableFuture.supplyAsync(()->"BreakBulkheadPools 隔离板超出最大数据限量 请稍后再试");

    }

    /**
     *  限流 --- 测试 接口
     * @param id
     * @return
     */
    @RequestMapping("/openFeign/RateLimiterTest/{id}")
    @RateLimiter(name = "cloub-consul-dao",fallbackMethod="myRateLimiterFallBack")
    public  String RateLimiterTest(@PathVariable("id") String id){
        return openFeignApi.bulkhead(id);
    }

    public  String myRateLimiterFallBack(String id,Throwable throwable){
        return "BreakBulkhead 你被限流了   ！！！1 ";
    }
}
