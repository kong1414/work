package com.kongww.work.controller;

import com.kongww.work.pojo.entity.RoleDO;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 11:09 2018/9/27
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 新增用户
     *
     * @param saveRequest
     * @return
     */
    @RequestMapping("/create")
    public ResultVO<Object> create(@RequestBody @Valid RoleDO saveRequest) {
        saveRequest.setGmtCreate(new Date());
        saveRequest.setUserCteate("admin");
        return roleService.create(saveRequest);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public ResultVO<Object> delete(Integer id) {
        return roleService.delete(id);
    }

    /**
     * 更新用户
     *
     * @param record
     * @return
     */
    @RequestMapping("/update")
    public ResultVO<Object> update(RoleDO record) {
        return roleService.update(record);
    }

    /**
     * 根据关键字列出用户
     *
     * @param keyword
     * @return
     */
    @RequestMapping("/list")
    public ResultVO<Object> list(@RequestParam(defaultValue = "") String keyword) {
        System.out.println(keyword.toString());
        return roleService.list(keyword);
    }

}
