
package com.atguigu.cloub.service.impl;

import com.atguigu.cloub.entity.UndoLog;
import com.atguigu.cloub.mapper.UndoLogMapper;
import com.atguigu.cloub.service.UndoLogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UndoLogServiceImpl implements UndoLogService {

        @Autowired
        private UndoLogMapper undoLogMapper;

/**
*  查询表undo_log所有信息
*/
@Override
public List<UndoLog> findAllUndoLog() { return undoLogMapper.findAllUndoLog();}

        /**
        *  根据主键branchId查询表undo_log信息
        *  @param branchId
        */
        @Override
        public UndoLog findUndoLogBybranchId(@Param("branchId") Long branchId) { return undoLogMapper.findUndoLogBybranchId(branchId);}

        /**
        *  根据条件查询表undo_log信息
        *  @param undoLog
        */
        @Override
        public List<UndoLog> findUndoLogByCondition(UndoLog undoLog) { return undoLogMapper.findUndoLogByCondition(undoLog);}

        /**
        *  根据主键branchId查询表undo_log信息
        *  @param branchId
        */
        @Override
        public Integer deleteUndoLogBybranchId(@Param("branchId") Long branchId) { return undoLogMapper.deleteUndoLogBybranchId(branchId);}

        /**
        *  根据主键branchId更新表undo_log信息
        *  @param undoLog
        */
        @Override
        public Integer updateUndoLogBybranchId(UndoLog undoLog) { return undoLogMapper.updateUndoLogBybranchId(undoLog);}

        /**
        *  新增表undo_log信息
        *  @param undoLog
        */
        @Override
        public Integer addUndoLog(UndoLog undoLog) { return undoLogMapper.addUndoLog(undoLog);}
}