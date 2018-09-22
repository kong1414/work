package com.kongww.work.service;

import com.kongww.work.pojo.bo.LoginResultBO;
import com.kongww.work.pojo.entity.SysDeptDO;
import com.kongww.work.pojo.entity.SysUserDO;
import com.kongww.work.pojo.vo.ResultVO;

import java.util.List;

/**
 * @Author: QiuGuanLin
 * @Description: 用户service
 * @Date: 23:36 2018/9/22
 */
public interface SysUserService {

    /**
     * 登陆
     * 允许任何id登陆
     *
     * @param username
     * @param password
     * @return
     */
    LoginResultBO login(String username, String password);

    /**
     * 通过姓名登陆
     *
     * @param name
     * @param password
     * @return
     */
    LoginResultBO loginByName(String name, String password);

    /**
     * 通过学号工号登陆
     *
     * @param workNo
     * @param password
     * @return
     */
    LoginResultBO loginByWorkNo(String workNo, String password);

    /**
     * 通过邮箱登陆
     *
     * @param mail
     * @param password
     * @return
     */
    LoginResultBO loginByMail(String mail, String password);

    /**
     * 通过手机号登陆
     *
     * @param mobilephone
     * @param password
     * @return
     */
    LoginResultBO loginByMobilephone(String mobilephone, String password);

    /**
     * @param record
     * @return
     */
    ResultVO create(SysDeptDO record);

    /**
     * 更新用户
     *
     * @param record 用户实体类
     * @return
     */
    ResultVO update(SysDeptDO record);

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
     * @return
     */
    ResultVO list(String keyWord);

    /**
     * 获取用户 通过主键Id
     *
     * @return
     */
    SysUserDO getById();

    /**
     * 根据姓名查询用户信息
     *
     * @return
     */
    List<SysUserDO> getByName();

    /**
     * 根据学号、工号查询用户信息
     *
     * @return
     */
    SysUserDO getByWorkNo();

    /**
     * 根据邮箱查询用户信息
     *
     * @return
     */
    SysUserDO getBymail();

    /**
     * 根据手机号查询用户信息
     *
     * @return
     */
    SysUserDO getMobilephone();

}
