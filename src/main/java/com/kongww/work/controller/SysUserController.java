package com.kongww.work.controller;

import com.kongww.work.pojo.bo.LoginResultBO;
import com.kongww.work.pojo.entity.SysUserDO;
import com.kongww.work.pojo.request.LoginRequest;
import com.kongww.work.pojo.request.UserSaveRequest;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.LoginType;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.pojo.vo.UserVO;
import com.kongww.work.service.SysUserService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: QiuGuanLin
 * @Description: 用户管理模块
 * @Date: 19:27 2018/9/22
 */
@RestController
@RequestMapping("api/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 创建用户
     *
     * @param userSaveRequest
     * @return
     */
    @RequestMapping("/create")
    public ResultVO<Object> create(@RequestParam UserSaveRequest userSaveRequest) {

        return null;
    }


    /**
     * 获取用户列表
     *
     * @param keyWord
     * @return
     */
    @RequestMapping("/list")
    public ResultVO<Object> list(@RequestParam(defaultValue = "") String keyWord) {
        if (keyWord.length() > 20) {
            return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "");
        }
        ResultVO resultVO = sysUserService.list(keyWord);
        return resultVO;
    }

    /**
     * 登陆
     *
     * @param loginRequest
     * @return
     */
    @RequestMapping(value = "/login")
    public ResultVO login(@RequestBody LoginRequest loginRequest) {
        ResultVO result = null;
        LoginResultBO res = null;

        if (loginRequest.getLoginType() == LoginType.LoginByAllType.getCode()) {
            res = sysUserService.loginByWorkNo(loginRequest.getAccount(), loginRequest.getPassword());
        } else if (loginRequest.getLoginType() == LoginType.LoginByName.getCode()) {
            res = sysUserService.loginByWorkNo(loginRequest.getAccount(), loginRequest.getPassword());
        } else if (loginRequest.getLoginType() == LoginType.LoginByWorkNo.getCode()) {
            res = sysUserService.loginByWorkNo(loginRequest.getAccount(), loginRequest.getPassword());
        } else if (loginRequest.getLoginType() == LoginType.LoginByMail.getCode()) {
            res = sysUserService.loginByWorkNo(loginRequest.getAccount(), loginRequest.getPassword());
        } else if (loginRequest.getLoginType() == LoginType.LoginByMobilephone.getCode()) {
            res = sysUserService.loginByWorkNo(loginRequest.getAccount(), loginRequest.getPassword());
        }

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
}
