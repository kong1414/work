package com.kongww.work.service;

import com.kongww.work.pojo.vo.ResultVO;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 18:59 2018/10/15
 */
public interface StockService {

    /**
     * @param keyword
     * @return
     */
    ResultVO list(String keyword);
}
