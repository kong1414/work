package com.kongww.work.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role_acl")
public class SysRoleAcl {
    @Id
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer pkId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限id
     */
    @Column(name = "acl_id")
    private Integer aclId;

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
     * @return pk_id
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * @param pkId
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限id
     *
     * @return acl_id - 权限id
     */
    public Integer getAclId() {
        return aclId;
    }

    /**
     * 设置权限id
     *
     * @param aclId 权限id
     */
    public void setAclId(Integer aclId) {
        this.aclId = aclId;
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