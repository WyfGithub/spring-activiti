package com.zswl.act.controller;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyf
 * @
 */
@RestController
public class MyProcessController {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    RepositoryService repositoryService;

    @RequestMapping("process")
    public void process(){


        repositoryService.createDeployment().addClasspathResource("processes/abc.bpmn").deploy();
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess_1");
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前节点为："+task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前节点为："+task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前节点为："+ task);
    }
}
