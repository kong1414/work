package com.kongww.work.service;

import com.kongww.work.pojo.entity.WarehouseDO;
import com.kongww.work.pojo.vo.ResultVO;


/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 21:34 2018/9/24
 */
public interface WarehouseService {

    /**
     * 创建仓库
     *
     * @param record
     * @return
     */
    ResultVO<Object> create(WarehouseDO record);

    /**
     * 删除仓库
     * 仓库内有商品提示无法删除
     *
     * @param id
     * @return
     */
    ResultVO<Object> delete(Integer id);

    /**
     * 更新仓库
     * 一定要传入id值
     *
     * @param record
     * @return
     */
    ResultVO<Object> update(WarehouseDO record);

    /**
     * 列出仓库
     * 并实现关键字查询
     *
     * @param keyword
     * @return
     */
    ResultVO<Object> list(String keyword);
}
