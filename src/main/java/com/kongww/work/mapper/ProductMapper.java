package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.ProductDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ProductMapper extends Mapper<ProductDO> {
}