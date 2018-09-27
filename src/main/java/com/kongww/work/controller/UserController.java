package com.kongww.work.controller;

import com.kongww.work.pojo.bo.LoginResultBO;
import com.kongww.work.pojo.request.LoginRequest;
import com.kongww.work.pojo.request.RegisterRequest;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.pojo.vo.SysUserVO;
import com.kongww.work.pojo.vo.UserVO;
import com.kongww.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    public ResultVO<Object> login(@RequestBody LoginRequest loginRequest) {
        ResultVO result = null;
        LoginResultBO res = null;

        res = userService.login(loginRequest);

        if (res.isSuccess()) {
            result = new ResultVO<UserVO>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), res.getUserVO(), "登陆成功");
        } else {
            result = new ResultVO<UserVO>(HttpCodeEnum.REQUEST_FAIL.getCode(), res.getUserVO(), "账户或密码错误");
        }
        return result;
    }

    /**
     * 登出
     *
     * @param userId
     * @param req
     * @return
     */
    @RequestMapping(value = "/logout")
    public ResultVO<Object> logout(Integer userId, HttpServletRequest req) {
        return null;
    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping("/register")
    public ResultVO<Object> register(@RequestParam RegisterRequest registerRequest) {
        return userService.create(registerRequest);
    }

    /**
     * 列出用户
     *
     * @param keyword
     * @return
     */
    @RequestMapping("/list")
    public ResultVO<Object> list(@RequestParam String keyword) {
        return userService.list(keyword);
    }

    /**
     * 更新用户
     *
     * @return
     */
    @RequestMapping("/update")
    public ResultVO<Object> update() {
        return null;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public ResultVO delete(@RequestParam Integer id) {
        return userService.delete(id);
    }

    /**
     * 登陆页查询账户
     *
     * @param keyword
     * @return
     */
    @RequestMapping("/queryList")
    public ResultVO<Object> queryList(@RequestParam(defaultValue = "") String keyword) {
        return userService.queryList(keyword);
    }

}
