package com.zswl.act.service;

import org.springframework.stereotype.Service;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
    @Override
    public void show1() {
        System.out.println("==============================启动流程1=========================================");
    }

    @Override
    public void show2() {
        System.out.println("==============================启动流程1=========================================");
    }
}
