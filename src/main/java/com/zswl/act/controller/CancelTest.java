package com.zswl.act.controller;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CancelTest {
    @RequestMapping("cancelTest")
    public void CancelTest() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService rs = processEngine.getRepositoryService();
        //运行时服务
        RuntimeService runtimeService = processEngine.getRuntimeService();

        TaskService taskService = processEngine.getTaskService();

        Deployment deployment = rs.createDeployment().addClasspathResource("processes/Cancel.bpmn").deploy();
        ProcessDefinition processDefinition = rs.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        ProcessInstance pi = runtimeService.startProcessInstanceById(processDefinition.getId());
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前流程任务： " + task.getName());
        //执行流程，没有这部，不会执行到下一步
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前流程任务：" + task.getName());
    }
}
