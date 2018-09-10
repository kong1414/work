package com.kongww.work.service.impl;

import com.kongww.work.mapper.UserMapper;
import com.kongww.work.pojo.bo.LoginResultBO;
import com.kongww.work.pojo.entity.User;
import com.kongww.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/9/10 22:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LoginResultBO loginById(int id, String password) {
        User user = userMapper.selectByPrimaryKey(id);
        boolean isSuccess = false;
        LoginResultBO result = new LoginResultBO();

        if (user == null) {
            result.setSuccess(isSuccess);
            result.setMsg("用户不存在");
            return result;
        }
        isSuccess = user.getPassword().equals(password);
        System.out.println(id);
        System.out.println(password);
        System.out.println(user.getId());
        System.out.println(user.getPassword());
        result.setSuccess(isSuccess);
        if (isSuccess) {
            result.setMsg("登陆成功");
        } else {
            result.setMsg("用户密码错误");
        }
        return result;
    }

    @Override
    public List<User> selectAll() {
        List<User> list = userMapper.selectAll();
        return list;
    }
}
