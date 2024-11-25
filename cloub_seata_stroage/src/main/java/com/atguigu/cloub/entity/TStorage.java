
package com.atguigu.cloub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;


/**
* t_storage : 
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class TStorage  implements Serializable {

private static final long serialVersionUID = 1L;

        /**
        * 主键 : id,  id
        */
        private String id;

        /**
        * product_id,  产品id
        */
        private String productId;

        /**
        * total,  总数
        */
        private BigDecimal total;

        /**
        * used,  已使用数量
        */
        private BigDecimal used;

        /**
        * residue,  剩余数量
        */
        private BigDecimal residue;

}

