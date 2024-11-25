package com.atguigu.cloub.controller;

import com.atguigu.cloub.common.ResponseResult;
import com.atguigu.cloub.openFeign.OpenFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GateWayController {

    @Autowired
    private OpenFeignApi openFeignApi;

    /**
     *  对外暴露 的 对外 查询单个对象的接口
     * @param id
     * @return
     */
    @RequestMapping("/openFeign/gateway/{id}")
    public ResponseResult gateway2024Byid(@PathVariable("id") String id){
      return  openFeignApi.gateway2024Byid(id);
    }


}
