package com.kongww.work.controller;

import com.kongww.work.pojo.entity.ProductWarehouseDO;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.ProductWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: QiuGuanLin
 * @Description: 仓库与产品的关联关系
 * 库存关系
 * @Date: 15:38 2018/10/5
 */
@RestController
@RequestMapping("/api/stock")
public class ProductWarehouseController {

    @Autowired
    private ProductWarehouseService productWarehouseService;

    /**
     * 新增仓库与产品的关联信息
     *
     * @param record
     * @return
     */
    @RequestMapping("/create")
    public ResultVO create(@RequestBody ProductWarehouseDO record) {
        if (record.getQuantity() < 1) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "参数错误");
        }
        return productWarehouseService.create(record);
    }

    /**
     * 删除仓库与产品的关联信息
     *
     * @return
     */
    @RequestMapping("/deleteById")
    public ResultVO deleteById(@RequestParam Integer id) {
        return productWarehouseService.deleteById(id);
    }

    /**
     * 更新产品数量
     * 所有参数都要正确
     *
     * @return
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody ProductWarehouseDO record) {
        if (record.getQuantity() < 1) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "参数错误");
        }
        return productWarehouseService.update(record);
    }

    @RequestMapping("/listByWarehouseId")
    public ResultVO listByWarehouseId(@RequestParam Integer warehouseId, @RequestParam(defaultValue = "") String keyword) {
        return productWarehouseService.listByWarehouseId(warehouseId, keyword);
    }
}
