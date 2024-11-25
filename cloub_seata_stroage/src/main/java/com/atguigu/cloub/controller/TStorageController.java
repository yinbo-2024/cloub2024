package com.atguigu.cloub.controller;

import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.entity.TStorage;
import com.atguigu.cloub.service.TStorageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TStorageController {

    @Autowired
    private TStorageService tStorageService;

        /**
        *  根据主键id查询表t_storage信息
        *  @param id
        */
    @PostMapping("/findTStorageByid")
    public TStorage findTStorageByid(@Param("id") String id) {
        return tStorageService.findTStorageByid(id);
    }

    /**
    *  根据条件查询表t_storage信息
    *  @param tStorage
    */
    @PostMapping("/findTStorageByCondition(TStorage tStorage")
    public List<TStorage> findTStorageByCondition(TStorage tStorage) {
        return tStorageService.findTStorageByCondition(tStorage);
    }

        /**
        *  根据主键id查询表t_storage信息
        *  @param id
        */
    @PostMapping("/deleteTStorageByid")
    public Integer deleteTStorageByid(@Param("id") String id) {
        return tStorageService.deleteTStorageByid(id);
    }

        /**
        *  根据主键id更新表t_storage信息
        *  @param tStorage
        */
    @RequestMapping("/updateTStorageByid")
    public ResponseResult updateTStorageByid(@RequestBody TStorage tStorage) {

        return ResponseResult.success(tStorageService.updateTStorageByid(tStorage));
    }

        /**
        *  新增表t_storage信息
        *  @param tStorage
        */
    @PostMapping("/addTStorage(TStorage")
    public Integer addTStorage(TStorage tStorage) {
        return tStorageService.addTStorage(tStorage);
    }
}


