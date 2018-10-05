package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.ProductDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductMapper extends Mapper<ProductDO> {

    /**
     * 列出所有产品
     *
     * @param keyword 关键字
     * @return
     */
    List<ProductDO> list(@Param("keyword") String keyword);

    /**
     * 列出产品id和名字
     * 通过名字
     *
     * @param keyword
     * @return
     */
    List<Map<String, Object>> listByName(@Param("keyword") String keyword);
}