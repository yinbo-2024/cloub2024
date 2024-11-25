package com.atguigu.cloub.controller;

import com.atguigu.cloub.entity.UndoLog;
import com.atguigu.cloub.service.UndoLogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UndoLogController {

    @Autowired
    private UndoLogService undoLogService;

        /**
        *  根据主键branchId查询表undo_log信息
        *  @param branchId
        */
    @PostMapping("/findUndoLogBybranchId")
    public UndoLog findUndoLogBybranchId(@Param("branchId") Long branchId) {
        return undoLogService.findUndoLogBybranchId(branchId);
    }

    /**
    *  根据条件查询表undo_log信息
    *  @param undoLog
    */
    @PostMapping("/findUndoLogByCondition(UndoLog undoLog")
    public List<UndoLog> findUndoLogByCondition(UndoLog undoLog) {
        return undoLogService.findUndoLogByCondition(undoLog);
    }

        /**
        *  根据主键branchId查询表undo_log信息
        *  @param branchId
        */
    @PostMapping("/deleteUndoLogBybranchId")
    public Integer deleteUndoLogBybranchId(@Param("branchId") Long branchId) {
        return undoLogService.deleteUndoLogBybranchId(branchId);
    }

        /**
        *  根据主键branchId更新表undo_log信息
        *  @param undoLog
        */
    @PostMapping("/updateUndoLogBybranchId")
    public Integer updateUndoLogBybranchId(UndoLog undoLog) {
        return undoLogService.updateUndoLogBybranchId(undoLog);
    }

        /**
        *  新增表undo_log信息
        *  @param undoLog
        */
    @PostMapping("/addUndoLog(UndoLog")
    public Integer addUndoLog(UndoLog undoLog) {
        return undoLogService.addUndoLog(undoLog);
    }
}


