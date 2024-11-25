
package com.atguigu.cloub.service.impl;

import com.atguigu.cloub.entity.TAccount;
import com.atguigu.cloub.mapper.TAccountMapper;
import com.atguigu.cloub.service.TAccountService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TAccountServiceImpl implements TAccountService {

        @Autowired
        private TAccountMapper tAccountMapper;

/**
*  查询表t_account所有信息
*/
@Override
public List<TAccount> findAllTAccount() { return tAccountMapper.findAllTAccount();}

        /**
        *  根据主键id查询表t_account信息
        *  @param id
        */
        @Override
        public TAccount findTAccountByid(@Param("id") String id) { return tAccountMapper.findTAccountByid(id);}

        /**
        *  根据条件查询表t_account信息
        *  @param tAccount
        */
        @Override
        public List<TAccount> findTAccountByCondition(TAccount tAccount) { return tAccountMapper.findTAccountByCondition(tAccount);}

        /**
        *  根据主键id查询表t_account信息
        *  @param id
        */
        @Override
        public Integer deleteTAccountByid(@Param("id") String id) { return tAccountMapper.deleteTAccountByid(id);}

        /**
        *  根据主键id更新表t_account信息
        *  @param tAccount
        */
        @Override
        public Integer updateTAccountByid(TAccount tAccount) { return tAccountMapper.updateTAccountByid(tAccount);}

        /**
        *  新增表t_account信息
        *  @param tAccount
        */
        @Override
        public Integer addTAccount(TAccount tAccount) { return tAccountMapper.addTAccount(tAccount);}
}