package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.SysUserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SysUserMapper extends Mapper<SysUserDO> {

    public List<SysUserDO> list(@Param("keyWord") String keyWord);

    /**
     * 搜索能作为账户名字的字段
     *
     * @param keyWord
     * @return
     */
    public List<String> selectAccount(@Param("keyWord") String keyWord);
}