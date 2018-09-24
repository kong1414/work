package com.kongww.work.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "role")
public class RoleDO {
    /**
     * 角色id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色的类型：0，用户 1，管理员角色，2：销售管理员，3，仓库管理员
     */
    private Integer type;

    /**
     * 状态，1：可用，0：冻结
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
    @Column(name = "user_cteate")
    private String userCteate;

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
     * 获取角色id
     *
     * @return id - 角色id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置角色id
     *
     * @param id 角色id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取角色的类型：0，用户 1，管理员角色，2：销售管理员，3，仓库管理员
     *
     * @return type - 角色的类型：0，用户 1，管理员角色，2：销售管理员，3，仓库管理员
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置角色的类型：0，用户 1，管理员角色，2：销售管理员，3，仓库管理员
     *
     * @param type 角色的类型：0，用户 1，管理员角色，2：销售管理员，3，仓库管理员
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取状态，1：可用，0：冻结
     *
     * @return status - 状态，1：可用，0：冻结
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，1：可用，0：冻结
     *
     * @param status 状态，1：可用，0：冻结
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
     * @return user_cteate - 创建人
     */
    public String getUserCteate() {
        return userCteate;
    }

    /**
     * 设置创建人
     *
     * @param userCteate 创建人
     */
    public void setUserCteate(String userCteate) {
        this.userCteate = userCteate == null ? null : userCteate.trim();
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