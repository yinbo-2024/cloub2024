
package com.atguigu.cloub.service;

import com.atguigu.cloub.entity.TAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAccountService{

/**
*  查询表t_account所有信息
*/
List<TAccount> findAllTAccount();

        /**
        *  根据主键id查询表t_account信息
        *  @param id
        */
        TAccount findTAccountByid(@Param("id") String id);

        /**
        *  根据条件查询表t_account信息
        *  @param tAccount
        */
        List<TAccount> findTAccountByCondition(TAccount tAccount);

        /**
        *  根据主键id查询表t_account信息
        *  @param id
        */
        Integer deleteTAccountByid(@Param("id") String id);

        /**
        *  根据主键id更新表t_account信息
        *  @param tAccount
        */
        Integer updateTAccountByid(TAccount tAccount);

        /**
        *  新增表t_account信息
        *  @param tAccount
        */
        Integer addTAccount(TAccount tAccount);
}
