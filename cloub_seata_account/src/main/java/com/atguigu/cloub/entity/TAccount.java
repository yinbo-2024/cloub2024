
package com.atguigu.cloub.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;


/**
* t_account : 
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class TAccount  implements Serializable {

private static final long serialVersionUID = 1L;

        /**
        * 主键 : id,  id
        */
        private String id;

        /**
        * user_id,  用户id
        */
        private String userId;

        /**
        * total,  总额度
        */
        private BigDecimal total;

        /**
        * used,  已使用额度
        */
        private BigDecimal used;

        /**
        * residue,  剩余额度
        */
        private BigDecimal residue;

}

