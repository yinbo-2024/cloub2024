
package com.atguigu.cloub.entity;

import com.mysql.jdbc.Blob;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;


/**
* undo_log : AT transaction mode undo table
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class UndoLog  implements Serializable {

private static final long serialVersionUID = 1L;

        /**
        * 主键 : branch_id,  branch transaction id
        */
        private Long branchId;

        /**
        * xid,  global transaction id
        */
        private String xid;

        /**
        * context,  undo_log context,such as serialization
        */
        private String context;

        /**
        * rollback_info,  rollback info
        */
        private  byte[] rollbackInfo;

        /**
        * log_status,  0:normal status,1:defense status
        */
        private Integer logStatus;

        /**
        * log_created,  create datetime
        */
        private Date logCreated;

        /**
        * log_modified,  modify datetime
        */
        private Date logModified;

}

