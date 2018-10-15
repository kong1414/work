package com.kongww.work.service.impl;

import com.kongww.work.mapper.StockListMapper;
import com.kongww.work.pojo.entity.StockListDO;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 18:59 2018/10/15
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockListMapper stockListMapper;

    @Override
    public ResultVO list(String keyword) {
        List<StockListDO> list = stockListMapper.list(keyword);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }
}
