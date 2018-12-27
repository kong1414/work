package com.kongww.work.service;

import com.kongww.work.exception.RequestFailException;
import com.kongww.work.pojo.entity.DictionaryDO;

import java.util.List;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/12/24 8:54
 * @version: 1.0
 */
public interface DictionaryService {

    /**
     * 列出所有节点
     *
     * @return
     */
    List<DictionaryDO> listDisplay();


    // List<DictionaryDO> listByTag(String tag);
    //

    /**
     * 新增父节点
     *
     * @param dictionaryDO
     * @return
     * @throws RequestFailException
     */
    boolean saveOrUpdate(DictionaryDO dictionaryDO) throws RequestFailException;

    List<DictionaryDO> listById(Integer id);

    /**
     * 删除节点
     *
     * @param ids
     * @return
     * @throws RequestFailException
     */
    boolean batchRemove(Integer[] ids) throws RequestFailException;

    // List<DictionaryDO> listFirstLevelChildrenByTag(String tag);
}
