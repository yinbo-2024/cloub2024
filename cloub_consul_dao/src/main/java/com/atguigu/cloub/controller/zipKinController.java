package com.atguigu.cloub.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class zipKinController {


    /**
     *  链路追踪 测试
     * @param id
     * @return
     */
    @RequestMapping("/zipkin/getId/{id}")
    public String getZipKin(@PathVariable("id") String id){
        return " 是的事实上事实"+ IdUtil.simpleUUID();
    }

}
