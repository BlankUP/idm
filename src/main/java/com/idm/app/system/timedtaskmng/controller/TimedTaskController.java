package com.idm.app.system.timedtaskmng.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.system.timedtaskmng.model.TaskTriggerInfo;
import com.idm.app.system.timedtaskmng.service.TimedTaskService;
import com.idm.common.page.PageVo;
import com.idm.common.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TimedTaskController {

    private Logger logger = Logger.getLogger(TimedTaskController.class);

    @Autowired
    private TimedTaskService timedTaskService;

    @RequestMapping("/task_trigger")
    public String taskTrigger(HttpServletRequest request)
    {
        return "taskTrigger";
    }

    @RequestMapping("/task_trigger_query")
    @ResponseBody
    public Object queryTaskInfo(HttpServletRequest request, String page, String rows)
    {
        int pageNum = Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");
        String taskName=request.getParameter("taskName");
        String taskGroup=request.getParameter("taskGroup");
        String subsystem=request.getParameter("subSystem");
        String state=request.getParameter("state");

        logger.info(">>>taskName["+taskName+"]");
        logger.info(">>>taskGroup["+taskGroup+"]");
        logger.info(">>>subsystem["+subsystem+"]");
        logger.info(">>>state["+state+"]");

        PageHelper.startPage(pageNum, pageSize);
        PageVo pv = null;
        PageInfo pageInfo=null;

        List<TaskTriggerInfo> taskList = timedTaskService.queryTaskInfo(taskName, taskGroup, subsystem, state);
        if(taskList!=null && taskList.size()>0)
        {
            logger.info(">>>查询成功 总记录["+taskList.size()+"]");
            pageInfo = new PageInfo(taskList);
            pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
            pv.setRows(taskList);
        }
        else if(taskList!=null && taskList.size()==0)
        {
            logger.info(">>>无记录");
            pageInfo = new PageInfo(taskList);
            pv = new PageVo(pageSize, pageNum, 0);
            pv.setError("无记录");

        }
        else
        {
            logger.error(">>>数据库错误");
            pageInfo = new PageInfo(taskList);
            pv = new PageVo(pageSize, pageNum, 0);
            pv.setError("数据库错误");
        }
        return pv;

    }

    @RequestMapping("/task_trigger_update")
    @ResponseBody
    public String addOrUpdateOrDeleteTask(HttpServletRequest request)
    {
        String option = request.getParameter("option");
        String taskName=request.getParameter("base.taskName");
        String taskGroup=request.getParameter("base.taskGroup");
        String taskClass=request.getParameter("base.taskClass");
        String triggerTime=request.getParameter("base.triggerTime");
        String subSystem=request.getParameter("base.subSystem");
        String state=request.getParameter("base.state");
        String createDate=request.getParameter("base.createDate");
        String createDateTime=request.getParameter("base.createDatetime");

        logger.info(">>>option["+option+"]");
        logger.info(">>>taskName["+taskName+"]");
        logger.info(">>>taskGroup["+taskGroup+"]");
        logger.info(">>>taskClass["+taskClass+"]");
        logger.info(">>>triggerTime["+triggerTime+"]");
        logger.info(">>>subsystem["+subSystem+"]");
        logger.info(">>>state["+state+"]");
        logger.info(">>>createDate["+createDate+"]");
        logger.info(">>>createDateTime["+createDateTime+"]");

        TaskTriggerInfo taskTriggerInfo = new TaskTriggerInfo();
        taskTriggerInfo.setTaskName(taskName);
        taskTriggerInfo.setTaskGroup(taskGroup);
        taskTriggerInfo.setTaskClass(taskClass);
        taskTriggerInfo.setTriggerTime(triggerTime);
        taskTriggerInfo.setSubSystem(subSystem);
        taskTriggerInfo.setState(state);

        if("add".equals(option))
        {
            if(StringUtils.isBlank(taskName)||StringUtils.isBlank(taskGroup)
                    ||StringUtils.isBlank(taskClass)||StringUtils.isBlank(triggerTime)
                    ||StringUtils.isBlank(subSystem))
            {
                return "任务名称、任务组、任务实现类、触发时间以及任务子系统必需输入";
            }
            String dateTime=DateUtil.getNowDatetime();
            taskTriggerInfo.setCreateDate(dateTime.substring(0,8));
            taskTriggerInfo.setCreateDatetime(dateTime);
            try {
                timedTaskService.addTaskInfo(taskTriggerInfo);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "添加定时任务失败";
            }
        }
        if("update".equals(option))
        {
            try {
                timedTaskService.updateTaskInfo(taskTriggerInfo);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "修改定时任务失败";
            }
        }

        if("delete".equals(option))
        {
            taskName=request.getParameter("taskName");
            taskGroup=request.getParameter("taskGroup");
            logger.info(">>>taskName["+taskName+"]");
            logger.info(">>>taskGroup["+taskGroup+"]");
            try {
                timedTaskService.deleteTaskInfo(taskName, taskGroup);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "删除定时任务失败";
            }
        }
        return null;
    }

}
