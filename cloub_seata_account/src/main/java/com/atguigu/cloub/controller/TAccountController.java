package com.atguigu.cloub.controller;

import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.entity.TAccount;
import com.atguigu.cloub.service.TAccountService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TAccountController {

    @Autowired
    private TAccountService tAccountService;

        /**
        *  根据主键id查询表t_account信息
        *  @param id
        */
    @PostMapping("/findTAccountByid")
    public TAccount findTAccountByid(@Param("id") String id) {
        return tAccountService.findTAccountByid(id);
    }

    /**
    *  根据条件查询表t_account信息
    *  @param tAccount
    */
    @PostMapping("/findTAccountByCondition(TAccount tAccount")
    public List<TAccount> findTAccountByCondition(TAccount tAccount) {
        return tAccountService.findTAccountByCondition(tAccount);
    }

        /**
        *  根据主键id查询表t_account信息
        *  @param id
        */
    @PostMapping("/deleteTAccountByid")
    public Integer deleteTAccountByid(@Param("id") String id) {
        return tAccountService.deleteTAccountByid(id);
    }

        /**
        *  根据主键id更新表t_account信息
        *  @param tAccount
        */
    @RequestMapping("/updateTAccountByid")
    public ResponseResult updateTAccountByid(@RequestBody TAccount tAccount) {
        return ResponseResult.success(tAccountService.updateTAccountByid(tAccount));
    }

        /**
        *  新增表t_account信息
        *  @param tAccount
        */
    @PostMapping("/addTAccount(TAccount")
    public Integer addTAccount(TAccount tAccount) {
        return tAccountService.addTAccount(tAccount);
    }
}


