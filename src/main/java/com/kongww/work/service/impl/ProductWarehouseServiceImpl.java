package com.kongww.work.service.impl;

import com.kongww.work.mapper.ProductMapper;
import com.kongww.work.mapper.ProductWarehouseMapper;
import com.kongww.work.mapper.StockListMapper;
import com.kongww.work.mapper.WarehouseMapper;
import com.kongww.work.pojo.entity.ProductDO;
import com.kongww.work.pojo.entity.ProductWarehouseDO;
import com.kongww.work.pojo.entity.StockListDO;
import com.kongww.work.pojo.entity.WarehouseDO;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.pojo.vo.StockVO;
import com.kongww.work.service.ProductWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 14:32 2018/10/3
 */
@Service
public class ProductWarehouseServiceImpl implements ProductWarehouseService {

    @Autowired
    private ProductWarehouseMapper productWarehouseMapper;

    @Autowired
    private StockListMapper stockListMapper;


    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    @Transactional
    public ResultVO create(ProductWarehouseDO record) {
        Example example = new Example(ProductWarehouseDO.class);
        example.createCriteria().andEqualTo("productId", record.getProductId()).andEqualTo("warehouseId", record.getWarehouseId());

        List<ProductWarehouseDO> list = productWarehouseMapper.selectByExample(example);

        if (list.isEmpty()) {
            productWarehouseMapper.insert(record);
        } else {
            ProductWarehouseDO newRecord = list.get(0);
            newRecord.setQuantity(newRecord.getQuantity() + record.getQuantity());
            productWarehouseMapper.updateByPrimaryKey(newRecord);
        }

        this.record(record);

        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "新增成功");
    }

    @Override
    public ResultVO deleteById(Integer id) {
        productWarehouseMapper.deleteByPrimaryKey(id);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "删除成功");
    }

    @Override
    public ResultVO update(ProductWarehouseDO record) {
        productWarehouseMapper.updateByPrimaryKey(record);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "更新成功");
    }

    @Override
    public ResultVO listByWarehouseId(Integer warehouseId, String keyword) {
        List<StockVO> list = productWarehouseMapper.listByWarehouseId(warehouseId, keyword);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), list, "");
    }

    @Override
    public ResultVO record(ProductWarehouseDO record) {

        ProductDO product = productMapper.selectByPrimaryKey(record.getProductId());
        WarehouseDO warehouse = warehouseMapper.selectByPrimaryKey(record.getWarehouseId());

        StockListDO stockListDO = new StockListDO();

        stockListDO.setProductId(product.getId());
        stockListDO.setProductName(product.getName());
        stockListDO.setWarehouseId(warehouse.getId());
        stockListDO.setWarehouseName(warehouse.getName());
        stockListDO.setUnitPrice(product.getUnitPrice());
        stockListDO.setQuantity(record.getQuantity());
        stockListDO.setUserId(10000);
        stockListDO.setUserName("admin");

        stockListMapper.insertSelective(stockListDO);
        return null;
    }
}
