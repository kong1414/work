package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.StockListDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface StockListMapper extends Mapper<StockListDO> {
    /**
     * 列出所有信息
     * 支持模糊搜索
     *
     * @param keyword 关键字
     * @return
     */
    List<StockListDO> list(@Param("keyword") String keyword);
}