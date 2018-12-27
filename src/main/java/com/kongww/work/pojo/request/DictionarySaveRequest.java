package com.kongww.work.pojo.request;


import com.kongww.work.pojo.entity.DictionaryDO;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/12/24 9:35
 * @version: 1.0
 */
@Data
@Accessors(chain = true)
public class DictionarySaveRequest {

    @NotNull(message = "{dictionary.id.null}")
    private Integer id;

    @NotBlank(message = "{dictionary.name.blank}")
    private String name;

    @NotBlank(message = "{dictionary.tag.blank}")
    private String tag;

    private String comment;

    private Integer sort;

    public DictionaryDO convertToDictionaryDO() {
        DictionaryDO dictionaryDO = new DictionaryDO();
        BeanUtils.copyProperties(this, dictionaryDO);
        return dictionaryDO;
    }

}