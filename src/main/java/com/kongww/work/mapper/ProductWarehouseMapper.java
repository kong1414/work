package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.ProductDO;
import com.kongww.work.pojo.entity.ProductWarehouseDO;
import com.kongww.work.pojo.vo.StockVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ProductWarehouseMapper extends Mapper<ProductWarehouseDO> {

    /**
     * 列出仓库中产品
     *
     * @param warehouseId
     * @param keyword
     * @return
     */
    List<StockVO> listByWarehouseId(@Param("warehouseId") Integer warehouseId, @Param("keyword") String keyword);

    /**
     * 删除仓库中产品
     *
     * @param warehouseId
     * @param productId
     * @return
     */
    Integer deleteProduct(@Param("warehouseId") Integer warehouseId, @Param("productId") Integer productId);

    /**
     * 修改仓库中产品数量
     * <p>
     * 理论上不应该存在直接修改产品数量，会导致统计失效
     *
     * @param warehouseId
     * @param productId
     * @param quantity
     * @return
     */
    Integer modifyQuantity(@Param("warehouseId") Integer warehouseId,
                           @Param("productId") Integer productId,
                           @Param("quantity") Integer quantity);

    /**
     * 检查某产品是否存在于某个仓库中
     *
     * @param productId
     * @return
     */
    Integer checkInStock(@Param("productId") Integer productId);


    /**
     * 查询是否已存在库存与产品关系
     *
     * @param warehouseId
     * @param productId
     * @return
     */
    ProductWarehouseDO selectByTwoId(@Param("warehouseId") Integer warehouseId,
                                     @Param("productId") Integer productId);

}