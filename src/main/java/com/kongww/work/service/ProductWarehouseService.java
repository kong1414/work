package com.kongww.work.service;

import com.kongww.work.pojo.entity.ProductWarehouseDO;
import com.kongww.work.pojo.vo.ResultVO;

public interface ProductWarehouseService {

    /**
     * 新增产品
     *
     * @return
     */
    ResultVO create(ProductWarehouseDO record);


    /**
     * 删除产品
     *
     * @param id
     * @return
     */
    ResultVO deleteById(Integer id);

    /**
     * 更新产品数量
     *
     * @return
     */
    ResultVO update(ProductWarehouseDO record);


    /**
     * 表格查询
     *
     * @param warehouseId
     * @param keyword
     * @return
     */
    ResultVO listByWarehouseId(Integer warehouseId, String keyword);
}
