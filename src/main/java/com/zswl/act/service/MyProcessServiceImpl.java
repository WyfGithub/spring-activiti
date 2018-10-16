//package com.zswl.act.service;
//
//import org.activiti.engine.*;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.activiti.engine.task.Task;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyProcessServiceImpl implements MyProcessesService {
//    @Autowired
//    private RuntimeService runtimeService;
//    @Override
//    public boolean startAcctivitiDemo() {
//        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
//        //
//        RepositoryService rs = engine.getRepositoryService();
//        RuntimeService runtimeService = engine.getRuntimeService();
//        TaskService taskService = engine.getTaskService();
//        rs.createDeployment().addClasspathResource("abc.bpmn").deploy();
//        ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess");
//        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
//        System.out.println("当前节点为：" + task.getName());
//        taskService.complete(task.getId());
//        task =  taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
//        System.out.println("当前节点为：" + task.getName());
//        taskService.complete(task.getId());
//        task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
//        System.out.println("当前节点为：" + task);
//
//        return false;
//    }
//}
