package com.kongww.work.service.impl;

import com.kongww.work.mapper.SysDeptMapper;
import com.kongww.work.pojo.entity.SysDeptDO;
import com.kongww.work.pojo.vo.HttpCodeEnum;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.service.SysDeptService;
import com.kongww.work.util.tree.DeptNode;
import com.kongww.work.util.tree.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public SysDeptDO get(Integer id) {

        return sysDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultVO<SysDeptDO> create(String deptName, Integer parentId, String userName) {
        SysDeptDO sysDeptDO = new SysDeptDO();

        sysDeptDO.setName(deptName);
        sysDeptDO.setFkParent(parentId);
        sysDeptDO.setUserCreate(userName);
        sysDeptDO.setGmtCreate(new Date());
        sysDeptDO.setEnabled((byte) 1);

        SysDeptDO parent = sysDeptMapper.selectByPrimaryKey(parentId);
        if (parent != null) {
            sysDeptDO.setFkParent(parent.getPkId());
            sysDeptDO.setLevel(parent.getLevel() + 1);
        } else {// 如果没有父节点则创建失败
            return new ResultVO<SysDeptDO>(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "");
        }
        Integer sort = sysDeptMapper.getMaxSort(sysDeptDO.getLevel());
        sysDeptDO.setSort(sort == null ? 1 : sort + 1);
        sysDeptMapper.insertSelective(sysDeptDO);
        // sysDeptMapper.create(sysDeptDO);

        return new ResultVO<SysDeptDO>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), sysDeptDO, "添加成功");
    }

    @Override
    public ResultVO<SysDeptDO> rename(String newName, Integer id, String userName) {
        // TODO: 2018/9/19
        return null;
    }

    @Override
    public ResultVO<SysDeptDO> update(SysDeptDO sysDeptDO, String userName) {
        // TODO: 2018/9/19
        return null;
    }

    @Override
    public ResultVO delete(Integer DeptId, String userName) {
        if (sysDeptMapper.getChildCount(DeptId) > 0) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "该部门下还有其他部门");
        }
        sysDeptMapper.deleteByPrimaryKey(DeptId);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "删除成功");
    }

    @Override
    public ResultVO<List<SysDeptDO>> listDeptFilterName(HttpServletRequest request, String deptName) {
        // TODO: 2018/9/19
        return null;
    }

    @Override
    public ResultVO<DeptNode> getDeptTree() {
        // 获取map
        List<Map<String, Object>> deptMap = sysDeptMapper.queryToMap();
        // 调用方法变成树
        DeptNode root = TreeUtil.parseDeptTree(deptMap);
        System.out.println(root);
        return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), root, "");
    }

}
