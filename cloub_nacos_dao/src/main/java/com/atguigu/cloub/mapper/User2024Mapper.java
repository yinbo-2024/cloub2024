
package com.atguigu.cloub.mapper;

import com.atguigu.cloub.entity.User2024;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User2024Mapper{

    /**
    *  查询表user2024所有信息
    */
    List<User2024> findAllUser2024();

    /**
    *  根据主键id查询表user2024信息
    *  @param id
    */
    User2024 findUser2024Byid(String id);

    /**
    *  根据条件查询表user2024信息
    *  @param user2024
    */
    List<User2024> findUser2024ByCondition(User2024 user2024);

    /**
    *  根据主键id查询表user2024信息
    *  @param id
    */
    Integer deleteUser2024Byid(String id);

    /**
    *  根据主键id更新表user2024信息
    *  @param user2024
    */
    Integer updateUser2024Byid(User2024 user2024);

    /**
    *  新增表user2024信息
    *  @param user2024
    */
    Integer addUser2024(User2024 user2024);

}
