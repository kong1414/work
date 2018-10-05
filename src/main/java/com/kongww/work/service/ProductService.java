package com.kongww.work.service;

import com.kongww.work.pojo.entity.ProductDO;
import com.kongww.work.pojo.vo.ResultVO;

/**
 * @Author: QiuGuanLin
 * @Description: 产品管理类
 * @Date: 10:54 2018/9/25
 */
public interface ProductService {

    /**
     * 新增产品
     * @param record
     * @return
     */
    ResultVO create(ProductDO record);


    /**
     * 删除产品
     * 如果产品存在于仓库中 应提示不能删除
     * @param id
     * @return
     */
    ResultVO delete(Integer id);

    /**
     * 更新产品信息
     * @param record
     * @return
     */
    ResultVO update(ProductDO record);

    /**
     * 列出所有产品
     * 支持查询
     * @param keyword
     * @return
     */
    ResultVO list(String keyword);


    /**
     * 列出所有产品 通过名字查询
     *
     * @param keyword
     * @return
     */
    ResultVO listByName(String keyword);




}
