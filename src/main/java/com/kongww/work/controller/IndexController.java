package com.kongww.work.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/9/10 22:06
 */
@RestController
public class IndexController {

    private static Logger logger = Logger.getLogger(String.valueOf(IndexController.class));

    @RequestMapping("/")
    public String index() {
        logger.info("进入index方法");
        return "hello index";
    }
}
