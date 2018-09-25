package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.UserDO;
import com.kongww.work.pojo.vo.UserVO;
import jdk.nashorn.internal.ir.RuntimeNode;
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
    UserDO getUserVO(@Param("account") String account);

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
    public List<UserVO> list(@Param("keyword") String keyword);

    /**
     * 搜索能作为账户名字的字段
     *
     * @param keyword
     * @return
     */
    public List<String> selectAccount(@Param("keyword") String keyword);
}