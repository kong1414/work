package com.kongww.work.controller;

import com.kongww.work.pojo.entity.WarehouseDO;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: QiuGuanLin
 * @Description: 仓库的处理类
 * @Date: 21:32 2018/9/24
 */
@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    /**
     * 新增仓库
     *
     * @param warehouseDO
     * @return
     */
    @RequestMapping("/create")
    public ResultVO<Object> create(@RequestParam WarehouseDO warehouseDO) {

        return warehouseService.create(warehouseDO);
    }

    /**
     * 删除仓库
     *
     * @param id 仓库的id
     * @return
     */
    @RequestMapping("/delete")
    public ResultVO<Object> delete(Integer id) {

        return warehouseService.delete(id);
    }

    /**
     * 更新仓库信息
     * id不为空
     *
     * @param warehouseDO 仓库信息请求
     * @return
     */
    @RequestMapping("/update")
    public ResultVO<Object> update(@RequestParam WarehouseDO warehouseDO) {
        if (warehouseDO.getId() == null || warehouseDO.getId() == 0) {
            return new ResultVO<>(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "出错");
        }

        return warehouseService.update(warehouseDO);
    }

    /**
     * 获取仓库数据
     *
     * @param keyword 关键字查询
     * @return
     */
    @RequestMapping("/list")
    public ResultVO<Object> list(@RequestParam(defaultValue = "") String keyword) {
        ResultVO res = warehouseService.list(keyword);
        return res;
    }
}
