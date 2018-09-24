package com.kongww.work.service.impl;

import com.kongww.work.mapper.UserMapper;
import com.kongww.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 21:28 2018/9/24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
}
