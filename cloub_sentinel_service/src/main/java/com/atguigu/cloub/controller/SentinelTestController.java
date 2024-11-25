package com.atguigu.cloub.controller;

import com.atguigu.cloub.service.Sentinel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelTestController {
    @Autowired
    private Sentinel sentinel;

    @RequestMapping("/sentinel/getA")
    public String getA(){
        return " Test A";
    }
    @RequestMapping("/sentinel/getB")
    public String getB(){
        return "Test B";
    }


    @RequestMapping("/sentinel/getC")
    public String getC(){
        return "c 调用 " +sentinel.getCommmens();
    }
    @RequestMapping("/sentinel/getD")
    public String getD(){
        return "d 调用 "+sentinel.getCommmens();
    }


    /**
     *  流控效果
     * @return
     */
    @RequestMapping("/sentinel/getE")
    public String getE(){
        System.out.println(System.currentTimeMillis()+"test 排队 等待");
        return "e 调用";
    }

}
