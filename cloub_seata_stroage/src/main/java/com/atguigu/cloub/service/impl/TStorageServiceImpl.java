
package com.atguigu.cloub.service.impl;

import com.atguigu.cloub.entity.TStorage;
import com.atguigu.cloub.mapper.TStorageMapper;
import com.atguigu.cloub.service.TStorageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TStorageServiceImpl implements TStorageService {

        @Autowired
        private TStorageMapper tStorageMapper;

/**
*  查询表t_storage所有信息
*/
@Override
public List<TStorage> findAllTStorage() { return tStorageMapper.findAllTStorage();}

        /**
        *  根据主键id查询表t_storage信息
        *  @param id
        */
        @Override
        public TStorage findTStorageByid(@Param("id") String id) { return tStorageMapper.findTStorageByid(id);}

        /**
        *  根据条件查询表t_storage信息
        *  @param tStorage
        */
        @Override
        public List<TStorage> findTStorageByCondition(TStorage tStorage) { return tStorageMapper.findTStorageByCondition(tStorage);}

        /**
        *  根据主键id查询表t_storage信息
        *  @param id
        */
        @Override
        public Integer deleteTStorageByid(@Param("id") String id) { return tStorageMapper.deleteTStorageByid(id);}

        /**
        *  根据主键id更新表t_storage信息
        *  @param tStorage
        */
        @Override
        public Integer updateTStorageByid(TStorage tStorage) { return tStorageMapper.updateTStorageByid(tStorage);}

        /**
        *  新增表t_storage信息
        *  @param tStorage
        */
        @Override
        public Integer addTStorage(TStorage tStorage) { return tStorageMapper.addTStorage(tStorage);}
}