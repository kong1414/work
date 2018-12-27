package com.kongww.work.pojo.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author czj
 * @version 1.0
 * @datetime 2018-09-05 17:40
 */
@Data
@Accessors(chain = true)
public class BatchRequest {

    @NotEmpty(message = "{batch.ids.null}")
    private Integer[] ids;

}
