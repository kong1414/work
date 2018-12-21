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
import com.kongww.work.util.MapBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

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
        UserDO checkuser = new UserDO();
        checkuser.setUsername(record.getUsername());
        UserDO res = userMapper.selectOne(checkuser);
        if (res != null) {
            return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "注册失败（用户名重复）");
        }
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
        // System.out.println(user);
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
            UserVO userVO = new UserVO(
                    user.getId(), user.getUsername(), user.getMobile(),
                    user.getEmail(), user.getRemark(), user.getLastLoginTime(),
                    user.getToken(), user.getPwErrorsCount());

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
    @Transactional(rollbackFor = Exception.class)
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
        // System.out.println(list.toString());
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }

    @Override
    public UserDO getByToken(String token) {
        Example example = new Example(UserDO.class);
        example.createCriteria().andEqualTo("token", token);
        UserDO userDO = userMapper.selectOneByExample(example);
        return userDO;
    }

    @Override
    public ResultVO<Object> checkName(String keyword) {
        boolean canRegister = false;
        if ("".equals(keyword) || keyword == null) {
            return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), true, "");
        }
        UserDO userDO = new UserDO();
        userDO.setUsername(keyword);
        UserDO res = userMapper.selectOne(userDO);
        if (res != null) {
            return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), false, "");
        }
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), true, "");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO<Object> refreshToken(Integer id) {
        UserDO updateBean = new UserDO();
        updateBean.setId(id);
        updateBean.setTokenTakeEffectTime(new Date());
        int count = userMapper.updateByPrimaryKeySelective(updateBean);
        if (count > 0) {
            return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "");
        } else {
            return new ResultVO(HttpCodeEnum.SYSTEM_ERROR.getCode(), null, "系统异常，请联系管理员");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultVO<Object> logout(Integer id, String token) throws IllegalArgumentException, NoSuchMethodException, SecurityException {
        // 检查请求退出的用户是否存在或是否可执行退出操作
        // UserDO userDO = this.getById(id);
        UserDO userDO = userMapper.selectByPrimaryKey(id);

        if (userDO == null) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "用户不存在，无法退出");
        } else if ((userDO.getToken() == null || "".equals(userDO.getToken()))
                || userDO.getTokenTakeEffectTime() == null
                || (userDO.getTokenAge() == null || userDO.getTokenAge() == 0)) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "用户已退出，请勿重复操作");
        }
        Map<String, Object> claims = JWTUtil.parserJavaWebToken(token);
        UserVO tokenUserVO = null;
        // 校验token是否被篡改，被篡改的token无法正确解析出tokenUserVO
        if (claims == null || !claims.containsKey(Gloal.TOKEN_USER_INFO_KEY)) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "请求处理失败");
        } else {
            Map<String, Object> tokenUserInfo = (LinkedHashMap<String, Object>) claims.get(Gloal.TOKEN_USER_INFO_KEY);
            try {
                tokenUserVO = MapBeanUtil.map2Bean(tokenUserInfo, UserVO.class);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                return new ResultVO(HttpCodeEnum.SYSTEM_ERROR.getCode(), null, "系统异常，请联系管理员");
            }
            if (tokenUserVO == null || tokenUserVO.getId() == null) {
                return new ResultVO(HttpCodeEnum.SYSTEM_ERROR.getCode(), null, "系统异常，请联系管理员");
            }
        }
        // 校验token携带的tokenUserVO与数据库用户信息是否一致
        UserDO userDOInDatabase = this.getByToken(token);
        if (userDOInDatabase == null || !userDOInDatabase.getId().equals(tokenUserVO.getId())) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "请求处理失败");
        }
        // 校验登出请求的用户id与tokenUserVO是否一致
        if (!userDOInDatabase.getId().equals(userDO.getId())) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "请求处理失败");
        }
        // 执行退出操作
        int count = userMapper.updateTokenDisabled(id);
        if (count > 0) {
            return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, null);
        } else {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "请求处理失败");
        }
    }

    @Override
    public ResultVO<Object> updatePass(HttpServletRequest request, String oldPass, String newPass) {

        // UserDO user = (UserDO) request.getAttribute(Gloal.REQUEST_USER_KEY);
        //TODO: 上述获取UserDO 还存在问题
        return new ResultVO<Object>(400, "", "尚未完成！");

        // UserDO userDO = new UserDO();
        // if (user.getPassword().toUpperCase().equals(oldPass.toUpperCase())) {
        //     userDO.setPassword(newPass);
        //     userDO.setId(user.getId());
        //     int i = userMapper.updateByPrimaryKeySelective(userDO);
        //     if (i == 1) {
        //         return new ResultVO<Object>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), "", "修改成功！");
        //     } else {
        //         return new ResultVO<Object>(400, "", "系统异常！");
        //     }
        // } else {
        //     return new ResultVO<Object>(400, "", "密码错误！");
        // }
    }
}
