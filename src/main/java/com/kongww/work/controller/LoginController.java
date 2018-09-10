package com.kongww.work.controller;

import com.kongww.work.pojo.bo.LoginResultBO;
import com.kongww.work.pojo.entity.User;
import com.kongww.work.pojo.request.LoginRequest;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/9/10 22:07
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginById")
    public ResultVO<User> loginById(@Valid @RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        System.out.println("id = " + loginRequest.getName());
        System.out.println("password = " + loginRequest.getPassword());
        ResultVO<User> result;
        LoginResultBO res = userService.loginById(Integer.parseInt(loginRequest.getName()), loginRequest.getPassword());
        if (res.isSuccess()) {
            result = new ResultVO<User>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), res.getUser(), res.getMsg());
        } else {
            result = new ResultVO<User>(HttpCodeEnum.NO_AUTH.getCode(), null, res.getMsg());
        }
        return result;

    }

    @RequestMapping("/select")
    public List<User> selectAll() {
        List<User> list = userService.selectAll();
        return list;
    }
}

