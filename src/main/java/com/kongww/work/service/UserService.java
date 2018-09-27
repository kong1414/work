package com.kongww.work.service;

import com.kongww.work.pojo.bo.LoginResultBO;
import com.kongww.work.pojo.entity.UserDO;
import com.kongww.work.pojo.request.LoginRequest;
import com.kongww.work.pojo.request.RegisterRequest;
import com.kongww.work.pojo.vo.ResultVO;

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
     * 删除用户
     *
     * @param id
     * @return
     */
    ResultVO delete(Integer id);


    /**
     * 禁用用户
     *
     * @param id
     * @return
     */
    ResultVO disable(Integer id);

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
}
