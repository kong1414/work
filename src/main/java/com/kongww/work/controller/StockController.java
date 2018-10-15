package com.kongww.work.controller;

import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 18:58 2018/10/15
 */
@RestController
@RequestMapping("/api/stocklist")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping("/list")
    public ResultVO list(@RequestParam(defaultValue = "") String keyword) {
        return stockService.list(keyword);
    }

}
