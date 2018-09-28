package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.RoleDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RoleMapper extends Mapper<RoleDO> {
    /**
     * 列出所有角色
     *
     * @param keyword 关键字
     * @return
     */
    List<RoleDO> list(@Param("keyword") String keyword);
}