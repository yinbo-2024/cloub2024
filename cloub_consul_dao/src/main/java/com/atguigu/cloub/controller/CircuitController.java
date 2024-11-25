package com.atguigu.cloub.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class CircuitController {

    /**
     *  断路器 测试
     * @param id
     * @return
     */
    @RequestMapping("/consul/circuit/{id}")
    public String circuit(@PathVariable("id") String id ){
        if(id.equals("5")){
            throw new RuntimeException(" id 不正确 ");
        }
        if(id.equals("9999")){
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return "id:"+id +"\t" + IdUtil.simpleUUID();
    }
    /**
     *  信号量 舱壁 测试
     * @param id
     * @return
     */
    @RequestMapping("/consul/bulkhead/{id}")
    public String bulkhead(@PathVariable("id") String id ){
        if(id.equals("5")){
            throw new RuntimeException(" id 不正确 ");
        }
        if(id.equals("9999")){
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return "id:"+id +"\t" + IdUtil.simpleUUID();
    }
}
