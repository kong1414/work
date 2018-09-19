package com.kongww.work.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_dept")
public class SysDeptDO {
    /**
     * 部门id
     */
    @Id
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer pkId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 可用标记
     */
    private Byte enabled;

    /**
     * 备注
     */
    private String remark;

    /**
     * 上级部门id
     */
    @Column(name = "fk_parent")
    private Integer fkParent;

    /**
     * 部门层级
     */
    private Integer level;

    /**
     * 部门在当前层级下的排序序号
     */
    private Integer sort;

    /**
     * 创建日期
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 创建人
     */
    @Column(name = "user_create")
    private String userCreate;

    /**
     * 修改日期
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 修改人
     */
    @Column(name = "user_modified")
    private String userModified;

    /**
     * 获取部门id
     *
     * @return pk_id - 部门id
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 设置部门id
     *
     * @param pkId 部门id
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取可用标记
     *
     * @return enabled - 可用标记
     */
    public Byte getEnabled() {
        return enabled;
    }

    /**
     * 设置可用标记
     *
     * @param enabled 可用标记
     */
    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
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
     * 获取上级部门id
     *
     * @return fk_parent - 上级部门id
     */
    public Integer getFkParent() {
        return fkParent;
    }

    /**
     * 设置上级部门id
     *
     * @param fkParent 上级部门id
     */
    public void setFkParent(Integer fkParent) {
        this.fkParent = fkParent;
    }

    /**
     * 获取部门层级
     *
     * @return level - 部门层级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置部门层级
     *
     * @param level 部门层级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取部门在当前层级下的排序序号
     *
     * @return sort - 部门在当前层级下的排序序号
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置部门在当前层级下的排序序号
     *
     * @param sort 部门在当前层级下的排序序号
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取创建日期
     *
     * @return gmt_create - 创建日期
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建日期
     *
     * @param gmtCreate 创建日期
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
     * 获取修改日期
     *
     * @return gmt_modified - 修改日期
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置修改日期
     *
     * @param gmtModified 修改日期
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