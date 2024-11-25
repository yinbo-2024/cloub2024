package com.atguigu.cloub.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SentinelResourceController {

    @RequestMapping("/sentinelRe/resource/{id}")
    @SentinelResource(value = "SentinelResource",blockHandler ="handExceptionResource",fallback = "handExceptionDown")
    public String Sentinel1(@PathVariable("id") String id){
        if(id.equalsIgnoreCase("0")){
            throw new RuntimeException("传出的 值是  0 直接异常");
        }
        return " 服务正在访问 访问正常";
    }

    /**
     * 限流 返回 兜底
     * @return
     */
    public String handExceptionResource(String id,BlockException blockExceptionk){
        return "Resource 被限流了";
    }


    /**
     * 服务 降级 兜底 返回
     * @param id
     * @param throwable
     * @return
     */
    public String handExceptionDown(String id,Throwable throwable){
      return "Resource 被降级了";
    }

    /**
     * 热点 数据 限流 测试
     * @param p1
     * @param p2
     * @return
     */
    @RequestMapping("/sentinel_Key")
    @SentinelResource(value = "sentinel_Key",blockHandler = "pointHand")
    public String  pointTest(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value ="p2",required = false) String p2){
           return  "正常访问";
    }

    public String pointHand(String p1,String p2,BlockException e){
          return "有热点数据被限制了";

    }
}
