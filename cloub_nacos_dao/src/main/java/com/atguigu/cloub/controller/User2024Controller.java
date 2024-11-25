package com.atguigu.cloub.controller;

import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.entity.User2024;
import com.atguigu.cloub.service.User2024Service;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
public class User2024Controller {

    @Autowired
    private User2024Service user2024Service;

    /**
     * 根据主键id查询表user2024信息
     *
     * @param id
     */
    @RequestMapping("/user-info/findUser2024Byid/{id}")
    public ResponseResult findUser2024Byid(@PathVariable("id") String id) {
        return ResponseResult.success(user2024Service.findUser2024Byid(id));
    }

    /**
     * 根据条件查询表user2024信息
     *
     * @param user2024
     */
    @RequestMapping("/user-info/findUser2024ByCondition")
    public ResponseResult findUser2024ByCondition(@RequestBody User2024 user2024) {
        return ResponseResult.success(user2024Service.findUser2024ByCondition(user2024));
    }

    /**
     * 根据主键id查询表user2024信息
     *
     * @param id
     */
    @RequestMapping("/user-info/deleteUser2024Byid/{id}")
    public ResponseResult deleteUser2024Byid(@PathVariable("id") String id) {
        return ResponseResult.success(user2024Service.deleteUser2024Byid(id));
    }

    /**
     * 根据主键id更新表user2024信息
     *
     * @param user2024
     */
    @RequestMapping("/user-info/updateUser2024Byid")
    public ResponseResult updateUser2024Byid(@RequestBody User2024 user2024) {
        return ResponseResult.success(user2024Service.updateUser2024Byid(user2024));
    }

    /**
     * 新增表user2024信息
     *
     * @param user2024
     */
    @RequestMapping("/user-info/addUser2024")
    public ResponseResult addUser2024(@RequestBody User2024 user2024) {
        return ResponseResult.success(user2024Service.addUser2024(user2024));
    }

    @RequestMapping("/nacos/findPort")
    public ResponseResult findPort(@Value("${server.port}") String port) {
        return ResponseResult.success("",port);
    }

}



