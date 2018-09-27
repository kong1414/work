package com.kongww.work.controller;

import com.kongww.work.pojo.bo.SysLoginResultBO;
import com.kongww.work.pojo.request.SysLoginRequest;
import com.kongww.work.pojo.request.UserSaveRequest;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.LoginType;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.pojo.vo.SysUserVO;
import com.kongww.work.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
     * 登陆页查询账户
     *
     * @param keyWord
     * @return
     */
    @RequestMapping("/queryList")
    public ResultVO<Object> queryList(@RequestParam(defaultValue = "") String keyWord) {
        if ("".equals(keyWord) || keyWord == null) {
            return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "");
        }
        ResultVO result = sysUserService.queryList(keyWord);
        return result;
    }

    /**
     * 登陆
     *
     * @param loginRequest
     * @return
     */
    @RequestMapping(value = "/login")
    public ResultVO login(@RequestBody SysLoginRequest loginRequest) {
        ResultVO result = null;
        SysLoginResultBO res = null;

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
            result = new ResultVO<SysUserVO>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), res.getSysUserVO(), "登陆成功");
        } else {
            result = new ResultVO<SysUserVO>(HttpCodeEnum.REQUEST_FAIL.getCode(), res.getSysUserVO(), "账户或密码错误");
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
