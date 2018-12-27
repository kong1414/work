package com.kongww.work.pojo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "dictionary")
@Data
@Accessors(chain = true)
public class DictionaryDO {
    @Id
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 父节点id
     */
    @Column(name = "fk_parent")
    private Integer parentId;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 标签
     */
    private String tag;

    /**
     * 备注
     */
    private String comment;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建者
     */
    @Column(name = "user_create")
    private String userCreate;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改者
     */
    @Column(name = "user_modified")
    private String userModified;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 是否有效：0否，1是
     */
    private Boolean enabled;

    /**
     * 是否显示在数据字典管理菜单中：0否，1是
     */
    private Boolean display;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 类别
     */
    private String category;

    /**
     * 是否允许有子节点 0否，1是
     */
    @Column(name = "allow_child")
    private Boolean allowChild;

    private List<DictionaryDO> childrenList = new ArrayList<>();
}