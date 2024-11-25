package com.atguigu.cloub.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.entity.User2024;
import com.atguigu.cloub.service.User2024Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;


@RestController
public class User2024Controller {

    @Autowired
    private User2024Service user2024Service;

        /**
        *  根据主键id查询表user2024信息
        *  @param id
        */
    @RequestMapping("/consul/findUser2024Byid/{id}")
    public ResponseResult  findUser2024Byid(@PathVariable("id") String id) {
        return ResponseResult.success(user2024Service.findUser2024Byid(id));
    }

    /**
    *  根据条件查询表user2024信息
    *  @param user2024
    */
    @RequestMapping("/consul/findUser2024ByCondition")
    public ResponseResult  findUser2024ByCondition(@RequestBody User2024 user2024) {
        return ResponseResult.success( user2024Service.findUser2024ByCondition(user2024));
    }

        /**
        *  根据主键id查询表user2024信息
        *  @param id
        */
    @RequestMapping("/consul/deleteUser2024Byid/{id}")
    public ResponseResult deleteUser2024Byid(@PathVariable("id") String id) {
        return ResponseResult.success(user2024Service.deleteUser2024Byid(id));
    }

        /**
        *  根据主键id更新表user2024信息
        *  @param user2024
        */
    @RequestMapping("/consul/updateUser2024Byid")
    public ResponseResult updateUser2024Byid(@RequestBody User2024 user2024) {
        return ResponseResult.success(user2024Service.updateUser2024Byid(user2024));
    }

        /**
        *  新增表user2024信息
        *  @param user2024
        */
    @RequestMapping("/consul/addUser2024")
    public ResponseResult addUser2024(@RequestBody User2024 user2024) {
        return ResponseResult.success(user2024Service.addUser2024(user2024));
    }

    /**
     * 从 注册中心拿 配置 数据
     */
    @Value("${server.port}")
    private String port;
    @RequestMapping("/consul/getConsul")
    public String getConsulInfo(@Value("${atguigu.info}") String atinfo){
        return "atguigu.info:"+atinfo+":"+port;
    }


    /**
     *  根据主键id查询表user2024信息
     *  请求时间测试
     *  @param id
     */
    @RequestMapping("/consul/findUsersById/{id}")
    public ResponseResult  findUsers(@PathVariable("id") String id) {
        System.out.println("请求测试  开始时间："+ DateUtil.now());
        try {
            TimeUnit.SECONDS.sleep(3);
            User2024 resp=user2024Service.findUser2024Byid(id);
            System.out.println("请求测试  结束时间："+ DateUtil.now());
            return   ResponseResult.success(resp);
        }catch (Exception e){
            System.out.println("请求测试  结束时间："+ DateUtil.now());
            return  ResponseResult.fail();

        }

    }

}



