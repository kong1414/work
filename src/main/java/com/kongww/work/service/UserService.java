package com.kongww.work.service;

import com.kongww.work.pojo.bo.LoginResultBO;
import com.kongww.work.pojo.entity.UserDO;
import com.kongww.work.pojo.request.LoginRequest;
import com.kongww.work.pojo.request.RegisterRequest;
import com.kongww.work.pojo.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: QiuGuanLin
 * @Description: 用户模块的业务处理
 * @Date: 21:28 2018/9/24
 */
public interface UserService {

    ResultVO<Object> create(RegisterRequest record);

    /**
     * 登陆
     * 允许任何id登陆
     *
     * @param loginRequest
     * @return
     */
    LoginResultBO login(LoginRequest loginRequest);

    /**
     * 更新用户
     *
     * @param record 用户实体类
     * @return
     */
    ResultVO update(UserDO record);

    /**
     * 重置密码
     * @param id
     * @return
     */
    ResultVO resetPassword(Integer id);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    ResultVO delete(Integer id);

    /**
     * 列出用户
     *
     * @param keyword
     * @return
     */
    ResultVO list(String keyword);

    /**
     * 用来查找所以符合关键字的学号姓名手机邮箱等
     *
     * @param keyword
     * @return
     */
    ResultVO queryList(String keyword);

    /**
     * 通过token值来查找用户
     *
     * @param token
     * @return
     */
    UserDO getByToken(String token);

    /**
     * 检查用户名是否冲突
     *
     * @param keyword
     * @return
     */
    ResultVO<Object> checkName(String keyword);

    /**
     * 刷新token
     *
     * @param id
     * @return
     */
    ResultVO<Object> refreshToken(Integer id);

    /**
     * 用户登出操作
     *
     * @param id
     * @param token
     * @return
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     */
    ResultVO<Object> logout(Integer id, String token) throws IllegalArgumentException, NoSuchMethodException, SecurityException;

    /**
     * 更新密码
     *
     * @param request
     * @param oldPass
     * @param newPass
     * @return
     */
    ResultVO<Object> updatePass(HttpServletRequest request, String oldPass, String newPass);
}
