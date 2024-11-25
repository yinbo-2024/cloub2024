
package com.atguigu.cloub.service.impl;

import com.atguigu.cloub.entity.User2024;
import com.atguigu.cloub.mapper.User2024Mapper;
import com.atguigu.cloub.service.User2024Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2024ServiceImpl implements User2024Service {

    @Autowired
    private User2024Mapper user2024Mapper;

    /**
     * 查询表user2024所有信息
     */
    @Override
    public List<User2024> findAllUser2024() {
        return user2024Mapper.findAllUser2024();
    }

    /**
     * 根据主键id查询表user2024信息
     *
     * @param id
     */
    @Override
    public User2024 findUser2024Byid(String id) {
        return user2024Mapper.findUser2024Byid(id);
    }

    /**
     * 根据条件查询表user2024信息
     *
     * @param user2024
     */
    @Override
    public List<User2024> findUser2024ByCondition(User2024 user2024) {
        return user2024Mapper.findUser2024ByCondition(user2024);
    }

    /**
     * 根据主键id查询表user2024信息
     *
     * @param id
     */
    @Override
    public Integer deleteUser2024Byid( String id) {
        return user2024Mapper.deleteUser2024Byid(id);
    }

    /**
     * 根据主键id更新表user2024信息
     *
     * @param user2024
     */
    @Override
    public Integer updateUser2024Byid(User2024 user2024) {
        return user2024Mapper.updateUser2024Byid(user2024);
    }

    /**
     * 新增表user2024信息
     *
     * @param user2024
     */
    @Override
    public Integer addUser2024(User2024 user2024) {
        return user2024Mapper.addUser2024(user2024);
    }
}