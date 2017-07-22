package com.ljm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liujm on 2017/6/19.
 */
@Controller

public class testcontroller {
    private Logger log= Logger.getLogger(testcontroller.class);

    @RequestMapping("/test/mytest")
    public String introductionView() {
        log.info("--->");
        return "layout/template";
    }
}
