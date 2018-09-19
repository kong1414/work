package com.kongww.work.service;

import com.kongww.work.pojo.entity.SysDeptDO;
import com.kongww.work.pojo.vo.DeptVO;
import com.kongww.work.pojo.vo.ResultVO;
import com.kongww.work.util.tree.DeptNode;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface SysDeptService {

    /**
     * id精确查找
     *
     * @param id 部门id
     * @return
     */
    public SysDeptDO get(Integer id);

    /**
     * 创建部门
     *
     * @param deptName 部门名字
     * @param parentId 上级部门id
     * @param userName 创建的用户
     * @return
     */
    public ResultVO<SysDeptDO> create(String deptName, Integer parentId, String userName);

    /**
     * 部门重命名
     *
     * @param newName  新名字
     * @param id       重命名的部门id
     * @param userName 修改人姓名
     * @return
     */
    public ResultVO<SysDeptDO> rename(String newName, Integer id, String userName);


    /**
     * 更新部门数据
     *
     * @param sysDeptDO
     * @return
     */
    public ResultVO<SysDeptDO> update(SysDeptDO sysDeptDO, String userName);

    /**
     * 删除部门
     * 需要注意内部是否有子节点
     *
     * @param DeptId
     * @return
     */
    public ResultVO<SysDeptDO> delete(Integer DeptId, String userName);

    /**
     * 部门名称模糊查询
     *
     * @param request
     * @param deptName
     * @return
     */
    public ResultVO<List<SysDeptDO>> listDeptFilterName(HttpServletRequest request, String deptName);


    /**
     * 获得整颗部门树
     *
     * @return
     */
    public ResultVO<DeptNode> getDeptTree();


}
