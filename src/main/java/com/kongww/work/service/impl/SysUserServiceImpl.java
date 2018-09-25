package com.kongww.work.service.impl;

import com.kongww.work.mapper.SysUserMapper;
import com.kongww.work.pojo.bo.SysLoginResultBO;
import com.kongww.work.pojo.entity.SysDeptDO;
import com.kongww.work.pojo.entity.SysUserDO;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.pojo.vo.SysUserVO;
import com.kongww.work.service.SysUserService;
import com.kongww.work.util.Gloal;
import com.kongww.work.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: QiuGuanLin
 * @Description: 用户service
 * @Date: 23:36 2018/9/22
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public SysLoginResultBO login(String username, String password) {
        return null;
    }

    @Override
    public SysLoginResultBO loginByName(String name, String password) {
        return null;
    }

    @Override
    public SysLoginResultBO loginByWorkNo(String workNo, String password) {
        SysLoginResultBO result = new SysLoginResultBO();
        boolean isSuccess = false;

        SysUserDO loginUser = new SysUserDO();
        loginUser.setWorkNo(workNo);
        SysUserDO user = sysUserMapper.selectOne(loginUser);

        if (user == null) {
            result.setSuccess(isSuccess);
            result.setMsg("用户不存在");
            return result;
        }

        isSuccess = user.getPassword().toUpperCase().equals(password.toUpperCase());
        result.setSuccess(isSuccess);
        if (isSuccess) {
            result.setMsg("登陆成功");
            SysUserVO sysUserVO = new SysUserVO(user.getPkId(), user.getName(), user.getWorkNo(), user.getMail(), user.getMobilephone(), user.getDeptId(), user.getStatus(), user.getRemark(), user.getPwErrorsCount());

            // 设置token
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put(Gloal.TOKEN_USER_INFO_KEY, sysUserVO);
            String token = JWTUtil.createJavaWebToken(claims);
            sysUserVO.setToken(token);
            result.setSysUserVO(sysUserVO);

            // 更新数据库
            SysUserDO updateUser = new SysUserDO();
            updateUser.setPkId(user.getPkId());
            updateUser.setPkId(user.getPkId());
            updateUser.setToken(token);
            updateUser.setTokenTakeEffectTime(new Date());
            updateUser.setTokenAge(Gloal.TOKEN_AGE);
            sysUserMapper.updateByPrimaryKeySelective(updateUser);
        } else {
            result.setMsg("用户密码错误");
        }
        return result;
    }

    @Override
    public SysLoginResultBO loginByMail(String mail, String password) {
        return null;
    }

    @Override
    public SysLoginResultBO loginByMobilephone(String mobilephone, String password) {
        return null;
    }

    @Override
    public ResultVO create(SysDeptDO record) {
        return null;
    }

    @Override
    public ResultVO update(SysDeptDO record) {
        return null;
    }

    @Override
    public ResultVO delete(Integer id) {
        return null;
    }

    @Override
    public ResultVO list(String keyWord) {
        List<SysUserDO> list = sysUserMapper.list(keyWord);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }

    @Override
    public SysUserDO getById() {
        return null;
    }

    @Override
    public List<SysUserDO> getByName() {
        return null;
    }

    @Override
    public SysUserDO getByWorkNo() {
        return null;
    }

    @Override
    public SysUserDO getBymail() {
        return null;
    }

    @Override
    public SysUserDO getMobilephone() {
        return null;
    }

    @Override
    public ResultVO queryList(String keyWord) {
        List<String> list = sysUserMapper.selectAccount(keyWord);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }
}
