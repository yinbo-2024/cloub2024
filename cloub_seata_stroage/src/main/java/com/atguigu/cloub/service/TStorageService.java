
package com.atguigu.cloub.service;

import com.atguigu.cloub.entity.TStorage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TStorageService{

/**
*  查询表t_storage所有信息
*/
List<TStorage> findAllTStorage();

        /**
        *  根据主键id查询表t_storage信息
        *  @param id
        */
        TStorage findTStorageByid(@Param("id") String id);

        /**
        *  根据条件查询表t_storage信息
        *  @param tStorage
        */
        List<TStorage> findTStorageByCondition(TStorage tStorage);

        /**
        *  根据主键id查询表t_storage信息
        *  @param id
        */
        Integer deleteTStorageByid(@Param("id") String id);

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
