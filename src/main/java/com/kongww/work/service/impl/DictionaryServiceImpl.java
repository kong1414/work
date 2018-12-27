package com.kongww.work.service.impl;

import com.kongww.work.exception.RequestFailException;
import com.kongww.work.mapper.DictionaryMapper;
import com.kongww.work.pojo.entity.DictionaryDO;
import com.kongww.work.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/12/24 8:54
 * @version: 1.0
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public List<DictionaryDO> listDisplay() {
        return dictionaryMapper.listDisplay();
    }

    @Override
    public boolean saveOrUpdate(DictionaryDO dictionaryDO) throws RequestFailException {
        // 层级
        int level = 1;
        // 类别
        String category = dictionaryDO.getTag();

        // 新增节点下的节点 暂时用不着。
        if (dictionaryDO.getParentId() != null) {
            DictionaryDO parentDictionaryDO = dictionaryMapper.selectByPrimaryKey(dictionaryDO.getParentId());
            if (parentDictionaryDO == null) {
                throw new RequestFailException("父节点id无效！");
            }
            level = parentDictionaryDO.getLevel() + 1;
            category = parentDictionaryDO.getCategory();
        }

        if (dictionaryDO.getId() == null) {
            // 新增

            dictionaryDO.setLevel(level)
                    .setCategory(category)
                    .setUserCreate("admin")
                    //TODO: 获取操作的用户
                    .setGmtCreate(new Date())
                    .setEnabled(true);

            return dictionaryMapper.insertSelective(dictionaryDO) > 0;
        } else { // 修改节点
            if (dictionaryMapper.selectByPrimaryKey(dictionaryDO.getId()) == null) {
                throw new RequestFailException("数据字典id无效！");
            }

            dictionaryDO.setLevel(level)
                    .setCategory(category)
                    .setTag(null)
                    // TAG 一经新增无法修改，只能改category的值
                    .setUserCreate("admin")
                    //TODO: 获取操作的用户
                    .setGmtCreate(new Date());

            return dictionaryMapper.updateByPrimaryKeySelective(dictionaryDO) > 0;
        }
    }

    @Override
    public List<DictionaryDO> listById(Integer id) {
        List<DictionaryDO> list = new ArrayList<>();
        list.add(dictionaryMapper.selectByPrimaryKey(id));
        return list;
    }

    @Override
    public boolean batchRemove(Integer[] ids) throws RequestFailException {
        for (Integer id : ids) {
            dictionaryMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
