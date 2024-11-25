
package com.atguigu.cloub.mapper;

import com.atguigu.cloub.entity.TStorage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TStorageMapper{

    /**
    *  查询表t_storage所有信息
    */
    List<TStorage> findAllTStorage();

    /**
    *  根据主键id查询表t_storage信息
    *  @param id
    */
    TStorage findTStorageByid( String id);

    /**
    *  根据条件查询表t_storage信息
    *  @param tStorage
    */
    List<TStorage> findTStorageByCondition(TStorage tStorage);

    /**
    *  根据主键id查询表t_storage信息
    *  @param id
    */
    Integer deleteTStorageByid( String id);

    /**
    *  根据主键id更新表t_storage信息
    *  @param tStorage
    */
    Integer updateTStorageByid(TStorage tStorage);

    /**
    *  新增表t_storage信息
    *  @param tStorage
    */
    Integer addTStorage(TStorage tStorage);

}
