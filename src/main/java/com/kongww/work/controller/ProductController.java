package com.kongww.work.controller;

import com.kongww.work.pojo.entity.ProductDO;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 10:53 2018/9/25
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 新增产品
     *
     * @param record
     * @return
     */
    @RequestMapping("/create")
    public ResultVO create(@RequestBody ProductDO record) {
        return productService.create(record);
    }

    /**
     * 删除产品
     * 如果产品存在于仓库中 应提示不能删除
     * @return
     */
    @RequestMapping("delete")
    public ResultVO delete(@RequestParam Integer id) {
        return productService.delete(id);
    }

    /**
     * 更新产品数量
     * @return
     */
    @RequestMapping("/update")
    public ResultVO update(@RequestBody ProductDO record) {
        return productService.update(record);
    }

    /**
     * 列出所有产品
     * 支持模糊查询
     * @param keyword
     * @return
     */
    @RequestMapping("/list")
    public ResultVO list(@RequestParam(defaultValue = "") String keyword) {
        return productService.list(keyword);
    }

    /**
     * 列出所有产品
     * 用于选择框的搜索
     * 姓名查询
     *
     * @param keyword
     * @return
     */
    @RequestMapping("/listByName")
    public ResultVO listByName(@RequestParam(defaultValue = "") String keyword) {
        return productService.listByName(keyword);
    }

}
