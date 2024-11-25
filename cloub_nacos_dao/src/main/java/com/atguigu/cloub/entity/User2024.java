package com.atguigu.cloub.entity;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * user2024 : 用户信息表
 */
@Data
@Table(name="user2024")
public class User2024 implements Serializable {

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

