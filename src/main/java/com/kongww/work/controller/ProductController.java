package com.kongww.work.controller;

import com.kongww.work.pojo.vo.ProductVO;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/create")
    public ResultVO create(@RequestBody ProductVO record) {

        return null;
    }

    @RequestMapping("delete")
    public ResultVO delete() {
        return null;
    }

    @RequestMapping("/update")
    public ResultVO update() {
        return null;
    }

    @RequestMapping("/list")
    public ResultVO list(String keyword) {
        return null;
    }


}
