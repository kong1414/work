package com.kongww.work.controller;

import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: QiuGuanLin
 * @Description: 用户登陆
 * @Date: 21:25 2018/9/24
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登陆
     *
     * @return
     */
    @RequestMapping("/login")
    public ResultVO<Object> login() {
        return null;
    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping("/register")
    public ResultVO<Object> register() {
        return null;
    }


}
