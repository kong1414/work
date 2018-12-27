package com.kongww.work.mapper;

import com.kongww.work.pojo.entity.DictionaryDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DictionaryMapper extends Mapper<DictionaryDO> {

    List<DictionaryDO> listDisplay();

}