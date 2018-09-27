package com.kongww.work.service;

import com.kongww.work.pojo.entity.RoleDO;
import com.kongww.work.pojo.vo.ResultVO;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 11:10 2018/9/27
 */
public interface RoleService {

    /**
     * 创建角色
     *
     * @param record
     * @return
     */
    ResultVO<Object> create(RoleDO record);

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    ResultVO<Object> delete(Integer id);

    /**
     * 更新角色
     *
     * @param record
     * @return
     */
    ResultVO<Object> update(RoleDO record);

    /**
     * 列出角色
     *
     * @param keyword
     * @return
     */
    ResultVO<Object> list(String keyword);


}
