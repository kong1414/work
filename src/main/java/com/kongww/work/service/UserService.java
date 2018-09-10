package com.kongww.work.service;

import com.kongww.work.pojo.bo.LoginResultBO;
import com.kongww.work.pojo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/9/10 22:15
 */
@Service
public interface UserService {

    /**
     * 用户登录操作
     *
     * @param id
     * @param password
     * @return
     */
    LoginResultBO loginById(int id, String password);

    List<User> selectAll();
}
