package com.kongww.work.service.impl;

import com.kongww.work.mapper.RoleMapper;
import com.kongww.work.pojo.entity.RoleDO;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 11:10 2018/9/27
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ResultVO<Object> create(RoleDO record) {
        roleMapper.insertSelective(record);
        return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "新增成功");
    }

    @Override
    public ResultVO<Object> delete(Integer id) {
        roleMapper.deleteByPrimaryKey(id);
        return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "删除成功");
    }

    @Override
    public ResultVO<Object> update(RoleDO record) {
        roleMapper.updateByPrimaryKeySelective(record);
        return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "更新成功");
    }

    @Override
    public ResultVO<Object> list(String keyword) {
        List<RoleDO> list = roleMapper.list(keyword);
        return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }
}
