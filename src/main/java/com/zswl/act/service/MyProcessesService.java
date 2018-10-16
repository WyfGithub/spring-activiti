package com.zswl.act.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


public interface MyProcessesService {
    /**
     *
     */
    @RequestMapping(value="startDemo",method = RequestMethod.GET)
    public boolean startAcctivitiDemo();
}
