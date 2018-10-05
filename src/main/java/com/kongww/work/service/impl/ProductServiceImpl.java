package com.kongww.work.service.impl;

import com.kongww.work.mapper.ProductMapper;
import com.kongww.work.mapper.ProductWarehouseMapper;
import com.kongww.work.pojo.entity.ProductDO;
import com.kongww.work.pojo.entity.ProductWarehouseDO;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 10:54 2018/9/25
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductWarehouseMapper productWarehouseMapper;


    @Override
    public ResultVO create(ProductDO record) {
        productMapper.insertSelective(record);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "新增成功");
    }

    @Override
    public ResultVO delete(Integer id) {
        Integer count = productWarehouseMapper.checkInStock(id);
        if (count > 0) {
            new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "尚有库存，无法删除");
        } else {
            productMapper.deleteByPrimaryKey(id);
        }
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "删除成功");
    }

    @Override
    public ResultVO update(ProductDO record) {
        productMapper.updateByPrimaryKeySelective(record);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "更新成功");
    }

    @Override
    public ResultVO list(String keyword) {
        List<ProductDO> list = productMapper.list(keyword);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }

    @Override
    public ResultVO listByName(String keyword) {
        List<Map<String, Object>> list = productMapper.listByName(keyword);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }
}
