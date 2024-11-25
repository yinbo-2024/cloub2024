
package com.atguigu.cloub.mapper;

import com.atguigu.cloub.entity.TAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TAccountMapper{

    /**
    *  查询表t_account所有信息
    */
    List<TAccount> findAllTAccount();

    /**
    *  根据主键id查询表t_account信息
    *  @param id
    */
    TAccount findTAccountByid( String id);

    /**
    *  根据条件查询表t_account信息
    *  @param tAccount
    */
    List<TAccount> findTAccountByCondition(TAccount tAccount);

    /**
    *  根据主键id查询表t_account信息
    *  @param id
    */
    Integer deleteTAccountByid( String id);

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
