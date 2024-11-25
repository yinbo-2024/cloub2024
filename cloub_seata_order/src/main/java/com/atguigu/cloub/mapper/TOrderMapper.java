
package com.atguigu.cloub.mapper;

import com.atguigu.cloub.entity.TOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TOrderMapper{

    /**
    *  查询表t_order所有信息
    */
    List<TOrder> findAllTOrder();

    /**
    *  根据主键id查询表t_order信息
    *  @param id
    */
    TOrder findTOrderByid( String id);

    /**
    *  根据条件查询表t_order信息
    *  @param tOrder
    */
    List<TOrder> findTOrderByCondition(TOrder tOrder);

    /**
    *  根据主键id查询表t_order信息
    *  @param id
    */
    Integer deleteTOrderByid( String id);

    /**
    *  根据主键id更新表t_order信息
    *  @param tOrder
    */
    Integer updateTOrderByid(TOrder tOrder);

    /**
    *  新增表t_order信息
    *  @param tOrder
    */
    Integer addTOrder(TOrder tOrder);

}
