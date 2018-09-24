package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.WarehouseDO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface WarehouseMapper extends Mapper<WarehouseDO> {
    /**
     * 列出所有仓库
     *
     * @param keyword 关键字
     * @return
     */
    List<WarehouseDO> list(String keyword);
}