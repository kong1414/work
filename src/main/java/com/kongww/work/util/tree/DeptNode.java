package com.kongww.work.util.tree;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;

public class DeptNode implements Serializable {

    /**
     * 节点编号
     */
    private Integer id;

    /**
     * 节点内容
     */
    private String name;

    /**
     * 父节点
     */
    private DeptNode parent;

    /**
     * 父节点id
     */
    @JsonIgnore
    private Integer parentId;

    /**
     * 排序
     */
    private Integer sort;

    private Integer level;

    private Date gmtCreate;

    private List<DeptNode> children = new ArrayList<DeptNode>();

    /**
     * 添加孩子节点
     *
     * @param deptNode 孩子节点
     */
    public void addChild(DeptNode deptNode) {
        this.children.add(deptNode);
    }

    @Override
    public String toString() {
        String result =
                "{" + "id : '" + id + "'" + ", name : '" + name + "'";
        if (children != null && children.size() != 0) {
            result += ", children : " + children.toString();
        } else {
            result += ", leaf : true";
        }
        return result;
    }

    /**
     * 对本层节点进行排序
     */
    public void sortChildren() {
        // 可根据不同的排序属性，传入不同的比较器，这里传入order字段的比较器
        Collections.sort(children, new DeptNodeOrderComparator<DeptNode>());
        // 对每个节点的下一层节点进行递归排序
        for (Iterator<DeptNode> it = children.iterator(); it.hasNext(); ) {
            ((DeptNode) it.next()).sortChildren();
        }
    }

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

    public DeptNode getParent() {
        return parent;
    }

    public void setParent(DeptNode parent) {
        this.parent = parent;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public List<DeptNode> getChildren() {
        return children;
    }

    public void setChildren(List<DeptNode> children) {
        this.children = children;
    }
}
