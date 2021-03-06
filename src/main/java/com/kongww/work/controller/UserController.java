package com.kongww.work.controller;

import com.kongww.work.pojo.bo.LoginResultBO;
import com.kongww.work.pojo.entity.UserDO;
import com.kongww.work.pojo.request.LoginRequest;
import com.kongww.work.pojo.request.RegisterRequest;
import com.kongww.work.pojo.request.UserUpdatePass;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.pojo.vo.UserVO;
import com.kongww.work.service.UserService;
import com.kongww.work.util.Gloal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Author: QiuGuanLin
 * @Description: 用户登陆
 * @Date: 21:25 2018/9/24
 */
@RestController
@RequestMapping("/api/user")
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
        ResultVO<Object> result = null;
        try {
            result = userService.logout(userId, req.getHeader(Gloal.REQUEST_HEADER_TOKEN_KEY));
        } catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
            return new ResultVO<Object>(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "");
        }
        return result;
    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping("/register")
    public ResultVO<Object> register(@Valid @RequestBody RegisterRequest registerRequest) {
        return userService.create(registerRequest);
    }

    /**
     * 列出用户
     *
     * @param keyword
     * @return
     */
    @RequestMapping("/list")
    public ResultVO<Object> list(@RequestParam(defaultValue = "") String keyword) {
        return userService.list(keyword);
    }

    /**
     * 新增用户
     *
     * @param record
     * @return
     */
    @RequestMapping("/create")
    public ResultVO<Object> create(@RequestBody RegisterRequest record) {
        return userService.create(record);
    }

    /**
     * 更新用户
     *
     * @return
     */
    @RequestMapping("/update")
    public ResultVO<Object> update(@RequestParam Integer id,
                                   @RequestParam String username,
                                   @RequestParam(defaultValue = "") String mobile,
                                   @RequestParam(defaultValue = "") String email,
                                   @RequestParam(defaultValue = "") String remark) {
        UserDO record = new UserDO();
        record.setId(id);
        record.setUsername(username);
        record.setMobile(mobile);
        record.setEmail(email);
        record.setRemark(remark);
        return userService.update(record);
    }

    /**
     * 重置用户密码
     *
     * @return
     */
    @RequestMapping("/reset")
    public ResultVO<Object> update(@RequestParam Integer id) {
        return userService.resetPassword(id);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public ResultVO reset(@RequestParam Integer id) {
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

    /**
     * 登陆页查询账户是否重复
     *
     * @param keyword
     * @return
     */
    @RequestMapping("/checkName")
    public ResultVO<Object> checkName(@RequestParam(defaultValue = "") String keyword) {
        return userService.checkName(keyword);
    }

    /**
     * 修改密码接口
     */

    @RequestMapping("/updatePassword")
    public ResultVO<Object> updatePass(HttpServletRequest request, @RequestBody UserUpdatePass userUpdatePass) {
        return userService.updatePass(request, userUpdatePass.getOldPass(), userUpdatePass.getNewPass());
    }

}
