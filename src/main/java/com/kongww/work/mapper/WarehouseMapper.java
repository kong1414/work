package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.WarehouseDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface WarehouseMapper extends Mapper<WarehouseDO> {
    /**
     * 列出所有仓库
     *
     * @param keyword 关键字
     * @return
     */
    List<WarehouseDO> list(@Param("keyword") String keyword);
}