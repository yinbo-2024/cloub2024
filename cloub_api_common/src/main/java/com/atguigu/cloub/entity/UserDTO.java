package com.atguigu.cloub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * user2024 : 用户信息表
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDTO implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 主键 : id,  主键
         */
        private String id;

        /**
         * user_name,  用户名
         */
        private String userName;

        /**
         * user_pwd,  用户密码
         */
        private String userPwd;

        /**
         * user_card,  证件号
         */
        private String userCard;

}

