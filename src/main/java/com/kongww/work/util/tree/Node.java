package com.kongww.work.util.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;

public class Node implements Serializable {

    private static final long serialVersionUID = 8180002560340519666L;

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
    private Node parent;

    /**
     * 父节点id
     */
    @JsonIgnore
    private Integer parentId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 层级
     */
    private Integer level;

    private Date gmtCreate;

    /**
     * 子节点列表
     */
    private List<Node> children = new ArrayList<Node>();

    // 添加孩子节点
    public void addChild(Node node) {
        this.children.add(node);
    }

    @Override
    public String toString() {
        String result = "{" + "id : '" + id + "'" + ", name : '" + name + "'";
        if (children != null && children.size() != 0) {
            result += ", children : " + children.toString();
        } else {
            result += ", leaf : true";
        }
        return result + "}";
    }

    public void sortChildren() {
        // 对本层节点进行排序
        // 可根据不同的排序属性，传入不同的比较器，这里传入order字段的比较器
        Collections.sort(children, new NodeOrderComparator<Node>());
        // 对每个节点的下一层节点进行递归排序
        for (Iterator<Node> it = children.iterator(); it.hasNext(); ) {
            ((Node) it.next()).sortChildren();
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
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

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
        if (this.parent == null) {
            this.parent = new Node();
        }
        this.parent.setId(this.parentId);
    }
}