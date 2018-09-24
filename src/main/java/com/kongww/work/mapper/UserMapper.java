package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.UserDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<UserDO> {
}