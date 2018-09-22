package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.SysDeptDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface SysDeptMapper extends Mapper<SysDeptDO> {

    /**
     * 查询成map形式
     *
     * @return
     */
    public List<Map<String, Object>> queryToMap();

    /**
     * 获取同级下最大的排序值
     *
     * @param level 排序值
     * @return
     */
    public Integer getMaxSort(Integer level);


    /**
     * 获取该部门下的子节点数量
     *
     * @param id
     * @return
     */
    public Integer getChildCount(Integer id);
}