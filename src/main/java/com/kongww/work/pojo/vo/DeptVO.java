package com.kongww.work.pojo.vo;

import com.kongww.work.pojo.entity.SysDeptDO;

import java.util.ArrayList;
import java.util.List;

public class DeptVO {

    private Long id;

    private String name;

    private Long parentId;

    private Integer level;

    private List<SysDeptDO> list = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<SysDeptDO> getList() {
        return list;
    }

    public void setList(List<SysDeptDO> list) {
        this.list = list;
    }
}
