package com.kongww.work.controller;

import com.kongww.work.pojo.dto.DeptTreeDTO;
import com.kongww.work.pojo.entity.SysDeptDO;
import com.kongww.work.pojo.entity.SysUserDO;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.SysDeptService;
import com.kongww.work.util.Gloal;
import com.kongww.work.util.tree.DeptNode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: QiuGuanLin
 * @Description: 部门管理控制类。
 * @Date: 10:58 2018/9/19
 */
@RestController
@RequestMapping("api/sys/dept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 新增部门
     *
     * @param name     新增部门名字
     * @param parentId 新增部门父节点id
     * @param request
     * @return
     */
    @RequestMapping("/create")
    public ResultVO<SysDeptDO> create(@RequestParam String name, @RequestParam Integer parentId, HttpServletRequest request) {
        if (StringUtils.isBlank(name)) {
            return new ResultVO<SysDeptDO>(400, null, "名称不能为空");
        }
        if (name.length() > 20) {
            return new ResultVO<SysDeptDO>(400, null, "名称不能超过20个字符");
        }

        // TODO: 2018/9/19 获取用户名字暂缓
        // SysUserDO sysUserDO = (SysUserDO) request.getAttribute(Gloal.REQUEST_USER_KEY);
        // String userName = sysUserDO.getName();// 获取当前用户的名字

        String userName = "admin";
        ResultVO<SysDeptDO> result = sysDeptService.create(name, parentId, userName);
        return result;
    }

    /**
     * 删除部门
     * 如果部门有子节点 则无法删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public ResultVO delete(@RequestParam Integer id) {
        String userName = "admin";
        // TODO: 2018/9/22 获取用户名
        ResultVO resultVO = sysDeptService.delete(id, userName);
        return resultVO;
    }

    /**
     * 获取部门树
     *
     * @return
     */
    @RequestMapping("/getDeptTree")
    public ResultVO<DeptNode> getDeptTree() {
        return sysDeptService.getDeptTree();
    }
}
