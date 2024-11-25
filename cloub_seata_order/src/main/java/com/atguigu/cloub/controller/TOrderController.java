package com.atguigu.cloub.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.entity.TOrder;
import com.atguigu.cloub.service.TOrderService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TOrderController {

    @Autowired
    private TOrderService tOrderService;

        /**
        *  根据主键id查询表t_order信息
        *  @param id
        */
    @PostMapping("/findTOrderByid")
    public TOrder findTOrderByid(@Param("id") String id) {
        return tOrderService.findTOrderByid(id);
    }

    /**
    *  根据条件查询表t_order信息
    *  @param tOrder
    */
    @PostMapping("/findTOrderByCondition(TOrder tOrder")
    public List<TOrder> findTOrderByCondition(TOrder tOrder) {
        return tOrderService.findTOrderByCondition(tOrder);
    }

        /**
        *  根据主键id查询表t_order信息
        *  @param id
        */
    @PostMapping("/deleteTOrderByid")
    public Integer deleteTOrderByid(@Param("id") String id) {
        return tOrderService.deleteTOrderByid(id);
    }

        /**
        *  根据主键id更新表t_order信息
        *  @param tOrder
        */
    @PostMapping("/updateTOrderByid")
    public Integer updateTOrderByid(TOrder tOrder) {
        return tOrderService.updateTOrderByid(tOrder);
    }

        /**
        *  新增表t_order信息
        *  @param tOrder
        */
    @RequestMapping("/addTOrderTOrder")
    public ResponseResult addTOrder(@RequestBody TOrder tOrder) {
        return ResponseResult.success(tOrderService.addTOrder(tOrder));
    }
}


