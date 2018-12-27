package com.kongww.work.controller;

import com.kongww.work.exception.RequestFailException;
import com.kongww.work.pojo.entity.DictionaryDO;
import com.kongww.work.pojo.request.BatchRequest;
import com.kongww.work.pojo.request.DictionaryChildrenSaveRequest;
import com.kongww.work.pojo.request.DictionarySaveRequest;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.pojo.vo.SuccessVO;
import com.kongww.work.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/12/24 8:53
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/list")
    public ResultVO<Object> listDisplay() {
        List<DictionaryDO> dictionaryDOList = dictionaryService.listDisplay();

        return new SuccessVO<>(dictionaryDOList, "获取数据字典列表成功！");
    }

    @RequestMapping("/listByTag")
    public ResultVO<Object> listByTag(@RequestParam(value = "tag", required = true) String tag) {
        // List<DictionaryDO> dictionaryDOList = dictionaryService.listByTag(tag);
        // return new SuccessVO<>(dictionaryDOList, "获取数据字典列表成功！");
        return null;
    }

    @RequestMapping("/save")
    public ResultVO<Object> save(@RequestBody DictionarySaveRequest dictionaryRequest) throws RequestFailException {
        DictionaryDO dictionaryDO = dictionaryRequest.convertToDictionaryDO();

        if (dictionaryService.saveOrUpdate(dictionaryDO)) {
            return new SuccessVO<>("新增数据字典成功！");
        }

        throw new RequestFailException("新增数据字典失败！");
    }

    @RequestMapping("/update")
    public ResultVO<Object> update(@RequestBody DictionarySaveRequest dictionaryRequest) throws RequestFailException {
        DictionaryDO dictionaryDO = dictionaryRequest.convertToDictionaryDO();

        if (dictionaryService.saveOrUpdate(dictionaryDO)) {
            return new SuccessVO<>("修改数据字典成功！");
        }

        throw new RequestFailException("修改数据字典失败！");
    }

    @RequestMapping("/batchRemove")
    public ResultVO<Object> batchRemove(@RequestBody BatchRequest dictionaryRequest) throws RequestFailException {
        if (dictionaryService.batchRemove(dictionaryRequest.getIds())) {
            return new SuccessVO<>("删除数据字典成功！");
        }

        throw new RequestFailException("删除数据字典失败！");
    }

    @RequestMapping("/saveChildren")
    public ResultVO<Object> saveChildren(@RequestBody DictionaryChildrenSaveRequest dictionaryRequest) throws RequestFailException {
        DictionaryDO dictionaryDO = dictionaryRequest.convertToDictionaryDO();

        if (dictionaryService.saveOrUpdate(dictionaryDO)) {
            return new SuccessVO<>("新增数据字典成功！");
        }

        throw new RequestFailException("新增数据字典失败！");
        // return null;
    }

    @RequestMapping("/updateChildren")
    public ResultVO<Object> updateChildren(@RequestBody DictionaryChildrenSaveRequest dictionaryRequest) throws RequestFailException {
        // DictionaryDO dictionaryDO = dictionaryRequest.convertToDictionaryDO();
        //
        // if (dictionaryService.saveOrUpdate(dictionaryDO)) {
        //     return new SuccessVO<>("修改数据字典成功！");
        // }
        //
        // throw new RequestFailException("修改数据字典失败！");
        return null;
    }

    @RequestMapping("/listById")
    public ResultVO<Object> listById(@RequestParam(value = "id", required = true) Integer id) {
        List<DictionaryDO> dictionaryDOList = dictionaryService.listById(id);

        return new SuccessVO<>(dictionaryDOList, "获取数据字典列表成功！");
    }
}
