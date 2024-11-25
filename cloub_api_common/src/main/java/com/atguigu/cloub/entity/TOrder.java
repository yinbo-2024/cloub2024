
package com.atguigu.cloub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;


/**
* t_order : 
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class TOrder implements Serializable {

private static final long serialVersionUID = 1L;

        /**
        * 主键 : id,  主键
        */
        private String id;

        /**
        * user_id,  用户ID
        */
        private String userId;

        /**
        * product_id,  产品ID
        */
        private String productId;

        /**
        * count,  数量
        */
        private Integer count;

        /**
        * money,  金额
        */
        private BigDecimal money;

        /**
        * status,  状态（0订单，1 创建，2已完结）
        */
        private Integer status;

}

