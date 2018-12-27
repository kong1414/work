package com.kongww.work.pojo.request;

import com.kongww.work.pojo.entity.DictionaryDO;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

/**
 * @author czj
 * @version 1.0
 * @datetime 2018-11-13 15:27
 */
@Data
@Accessors(chain = true)
public class DictionaryChildrenSaveRequest {

    @NotNull(message = "{dictionary.id.null}")
    private Integer id;

    @NotNull(message = "{dictionary.parentId.null}")
    private Integer parentId;

    @NotBlank(message = "{dictionary.name.blank}")
    private String name;

    private Integer sort;

    public DictionaryDO convertToDictionaryDO() {
        DictionaryDO dictionaryDO = new DictionaryDO();

        BeanUtils.copyProperties(this, dictionaryDO);

        return dictionaryDO;
    }

}
