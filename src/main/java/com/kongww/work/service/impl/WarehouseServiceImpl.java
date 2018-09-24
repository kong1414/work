package com.kongww.work.service.impl;

import com.kongww.work.mapper.WarehouseMapper;
import com.kongww.work.pojo.entity.WarehouseDO;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 21:35 2018/9/24
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public ResultVO<Object> create(WarehouseDO record) {
        warehouseMapper.insert(record);
        return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "新增仓库成功");
    }

    @Override
    public ResultVO<Object> delete(Integer id) {
        warehouseMapper.deleteByPrimaryKey(id);
        return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "删除成功");
    }

    @Override
    public ResultVO<Object> update(WarehouseDO record) {
        warehouseMapper.updateByPrimaryKeySelective(record);
        return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "更新成功");
    }

    @Override
    public ResultVO<Object> list(String keyword) {
        List<WarehouseDO> list = warehouseMapper.list(keyword);
        return new ResultVO<>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }
}
