package com.idm.app.system.timedtaskmng.mapper;

import com.idm.app.system.timedtaskmng.model.TaskTriggerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TimedTaskMapper {

    List<TaskTriggerInfo> queryTaskInfo(@Param("taskName") String taskName, @Param("taskGroup") String taskGroup, @Param("subsystem") String subsystem, @Param("state") String state);

    long addTaskInfo(TaskTriggerInfo taskTriggerInfo) throws Exception;

    long updateTaskInfo(TaskTriggerInfo taskTriggerInfo) throws Exception;

    long deleteTaskInfo(@Param("taskName") String taskName, @Param("taskGroup") String taskGroup) throws Exception;
}
