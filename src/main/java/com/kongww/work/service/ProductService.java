package com.kongww.work.service;

import com.kongww.work.pojo.vo.ProductVO;
import com.kongww.work.pojo.vo.ResultVO;

/**
 * @Author: QiuGuanLin
 * @Description: 产品管理类
 * @Date: 10:54 2018/9/25
 */
public interface ProductService {

    /**
     * 新增产品
     *
     * @return
     */
    ResultVO create();


    /**
     * 删除产品
     *
     * @param product_id
     * @param warehouse_id
     * @return
     */
    ResultVO delete(Integer product_id, Integer warehouse_id);

    /**
     * 更新产品
     *
     * @return
     */
    ResultVO update();


    /**
     * @param warehouse_id
     * @param keyword
     * @return
     */
    ResultVO list(Integer warehouse_id, String keyword);
}
