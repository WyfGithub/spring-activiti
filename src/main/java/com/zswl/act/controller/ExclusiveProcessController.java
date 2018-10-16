package com.zswl.act.controller;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述 : 网关的测试类
 *
 * @autor wangyf
 * @create 2018/10/16
 */
@RestController
public class ExclusiveProcessController {
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    TaskService taskService;
    @RequestMapping("exclusiveProcess")
    public String exclusiveProcess() {
        Map map = new HashMap();
        map.put("type",1);
        map.put("opinion",3);
        repositoryService.createDeployment().addClasspathResource("processes/ExclusiveProcess.bpmn").deploy();
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess_Exclusive",map);
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前节点为："+task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前节点为："+task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前节点为："+ task);
        return "abc";
    }
}
