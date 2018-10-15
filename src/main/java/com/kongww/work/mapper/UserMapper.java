package com.kongww.work.mapper;

import com.kongww.work.pojo.dto.UserDTO;
import com.kongww.work.pojo.entity.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<UserDO> {

    /**
     * 获取窗口
     *
     * @param account
     * @return
     */
    UserDO getUserVOByAccount(@Param("account") String account);

    /**
     * 检查是否存在重复的
     * 用户名手机号邮箱
     *
     * @param account
     * @return
     */
    Integer checkRepeat(@Param("account") String account);

    /**
     * 获取用户列表
     *
     * @param keyword
     * @return
     */
    public List<UserDTO> list(@Param("keyword") String keyword);

    /**
     * 搜索能作为账户名字的字段
     *
     * @param keyword
     * @return
     */
    public List<String> selectAccount(@Param("keyword") String keyword);
}