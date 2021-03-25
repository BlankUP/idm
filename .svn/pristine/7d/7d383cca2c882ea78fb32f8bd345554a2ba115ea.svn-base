package com.idm.app.system.timedtaskmng.service;

import com.idm.app.system.timedtaskmng.mapper.TimedTaskMapper;
import com.idm.app.system.timedtaskmng.model.TaskTriggerInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TimedTaskService {

    @Resource
    private TimedTaskMapper timedTaskMapper;

    public List<TaskTriggerInfo> queryTaskInfo(String taskName, String taskGroup, String subsystem, String state)
    {
        return timedTaskMapper.queryTaskInfo(taskName, taskGroup, subsystem,state);
    }

    public long addTaskInfo(TaskTriggerInfo taskTriggerInfo) throws Exception
    {
        return timedTaskMapper.addTaskInfo(taskTriggerInfo);
    }

    public long updateTaskInfo(TaskTriggerInfo taskTriggerInfo) throws Exception
    {
        return timedTaskMapper.updateTaskInfo(taskTriggerInfo);
    }

    public long deleteTaskInfo(String taskName, String taskGroup) throws Exception
    {
        return timedTaskMapper.deleteTaskInfo(taskName, taskGroup);
    }
}
