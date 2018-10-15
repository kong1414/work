package com.kongww.work.service.impl;

import com.kongww.work.mapper.UserMapper;
import com.kongww.work.pojo.bo.LoginResultBO;
import com.kongww.work.pojo.dto.UserDTO;
import com.kongww.work.pojo.entity.UserDO;
import com.kongww.work.pojo.request.LoginRequest;
import com.kongww.work.pojo.request.RegisterRequest;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.pojo.vo.UserVO;
import com.kongww.work.service.UserService;
import com.kongww.work.util.Gloal;
import com.kongww.work.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 21:28 2018/9/24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVO<Object> create(RegisterRequest record) {

        UserDO userDO = new UserDO();
        userDO.setUsername(record.getUsername());
        userDO.setPassword(record.getPassword());
        userDO.setMobile(record.getMobile());
        userDO.setEmail(record.getEmail());
        userDO.setRemark(record.getRemark());
        userMapper.insertSelective(userDO);
        return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "创建成功");
    }

    @Override
    public LoginResultBO login(LoginRequest loginRequest) {
        LoginResultBO result = new LoginResultBO();
        boolean isSuccess = false;

        UserDO user = userMapper.getUserVOByAccount(loginRequest.getAccount());
        System.out.println(user);
        if (user == null) {
            result.setSuccess(isSuccess);
            result.setMsg("用户不存在");
            return result;
        }
        // 验证密码
        isSuccess = user.getPassword().toUpperCase().equals(loginRequest.getPassword().toUpperCase());
        result.setSuccess(isSuccess);

        if (isSuccess) {
            result.setMsg("登陆成功");
            UserVO userVO = new UserVO(user.getId(), user.getUsername(), user.getMobile(), user.getEmail(), user.getRemark(), user.getLastLoginTime(), user.getToken(), user.getPwErrorsCount());


            // 设置token
            UserVO usertoken = userVO;
            Map<String, Object> claims = new HashMap<String, Object>();
            usertoken.setToken("");
            // 将其token设为空，防止token太长存不进数据库
            claims.put(Gloal.TOKEN_USER_INFO_KEY, usertoken);
            String token = JWTUtil.createJavaWebToken(claims);
            userVO.setToken(token);
            result.setUserVO(userVO);

            // 更新数据库
            UserDO updateUser = new UserDO();
            updateUser.setId(user.getId());
            updateUser.setToken(token);
            updateUser.setTokenTakeEffectTime(new Date());
            updateUser.setTokenAge(Gloal.TOKEN_AGE);

            userMapper.updateByPrimaryKeySelective(updateUser);
        }
        return result;
    }

    @Override
    public ResultVO update(UserDO record) {
        userMapper.updateByPrimaryKeySelective(record);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "更新成功");
    }

    @Override
    public ResultVO resetPassword(Integer id) {
        UserDO record = new UserDO();
        record.setId(id);
        record.setPassword("ea48576f30be1669971699c09ad05c94");
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "重置成功");
    }

    @Override
    public ResultVO delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "删除成功");
    }

    @Override
    public ResultVO list(String keyword) {
        List<UserDTO> list = userMapper.list(keyword);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }

    @Override
    public ResultVO queryList(String keyword) {
        if ("".equals(keyword) || keyword == null) {
            return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "");
        }
        List<String> list = userMapper.selectAccount(keyword);
        System.out.println(list.toString());
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }
}
