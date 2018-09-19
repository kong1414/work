package com.kongww.work.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_acl_module")
public class SysAclModuleDO {
    /**
     * 权限模块id
     */
    @Id
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer pkId;

    /**
     * 权限模块名称
     */
    private String name;

    /**
     * 上级权限模块id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 权限模块层级
     */
    private String level;

    /**
     * 权限模块在当前层级下的顺序，由小到大
     */
    private Integer sort;

    /**
     * 状态，1：正常，0：冻结
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 创建人
     */
    @Column(name = "user_create")
    private String userCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 修改人
     */
    @Column(name = "user_modified")
    private String userModified;

    /**
     * 获取权限模块id
     *
     * @return pk_id - 权限模块id
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 设置权限模块id
     *
     * @param pkId 权限模块id
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 获取权限模块名称
     *
     * @return name - 权限模块名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限模块名称
     *
     * @param name 权限模块名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取上级权限模块id
     *
     * @return parent_id - 上级权限模块id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级权限模块id
     *
     * @param parentId 上级权限模块id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取权限模块层级
     *
     * @return level - 权限模块层级
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置权限模块层级
     *
     * @param level 权限模块层级
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 获取权限模块在当前层级下的顺序，由小到大
     *
     * @return sort - 权限模块在当前层级下的顺序，由小到大
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置权限模块在当前层级下的顺序，由小到大
     *
     * @param sort 权限模块在当前层级下的顺序，由小到大
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取状态，1：正常，0：冻结
     *
     * @return status - 状态，1：正常，0：冻结
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，1：正常，0：冻结
     *
     * @param status 状态，1：正常，0：冻结
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取创建人
     *
     * @return user_create - 创建人
     */
    public String getUserCreate() {
        return userCreate;
    }

    /**
     * 设置创建人
     *
     * @param userCreate 创建人
     */
    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate == null ? null : userCreate.trim();
    }

    /**
     * 获取修改时间
     *
     * @return gmt_modified - 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取修改人
     *
     * @return user_modified - 修改人
     */
    public String getUserModified() {
        return userModified;
    }

    /**
     * 设置修改人
     *
     * @param userModified 修改人
     */
    public void setUserModified(String userModified) {
        this.userModified = userModified == null ? null : userModified.trim();
    }
}