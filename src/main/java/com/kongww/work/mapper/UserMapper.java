package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.User;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public interface UserMapper extends Mapper<User> {
}