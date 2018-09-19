package com.kongww.work.pojo.dto;

import java.util.Date;
import java.util.List;

public class DeptTreeDTO {
    private Integer id;

    private String name;

    private Integer parentId;

    private List<DeptTreeDTO> children;

    private Integer sort;

    private Integer level;

    private Date gmtCreate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<DeptTreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<DeptTreeDTO> children) {
        this.children = children;
    }
}
