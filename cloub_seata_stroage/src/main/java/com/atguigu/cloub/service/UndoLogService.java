
package com.atguigu.cloub.service;

import com.atguigu.cloub.entity.UndoLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UndoLogService{

/**
*  查询表undo_log所有信息
*/
List<UndoLog> findAllUndoLog();

        /**
        *  根据主键branchId查询表undo_log信息
        *  @param branchId
        */
        UndoLog findUndoLogBybranchId(@Param("branchId") Long branchId);

        /**
        *  根据条件查询表undo_log信息
        *  @param undoLog
        */
        List<UndoLog> findUndoLogByCondition(UndoLog undoLog);

        /**
        *  根据主键branchId查询表undo_log信息
        *  @param branchId
        */
        Integer deleteUndoLogBybranchId(@Param("branchId") Long branchId);

        /**
        *  根据主键branchId更新表undo_log信息
        *  @param undoLog
        */
        Integer updateUndoLogBybranchId(UndoLog undoLog);

        /**
        *  新增表undo_log信息
        *  @param undoLog
        */
        Integer addUndoLog(UndoLog undoLog);
}
