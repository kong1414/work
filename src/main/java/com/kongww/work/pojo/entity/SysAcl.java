package com.kongww.work.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_acl")
public class SysAcl {
    @Id
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer pkId;

    /**
     * 权限码
     */
    private String code;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限所在的权限模块id
     */
    @Column(name = "acl_module_id")
    private Integer aclModuleId;

    /**
     * 请求的url, 可以填正则表达式
     */
    private String url;

    /**
     * 类型，1：菜单，2：按钮，3：其他
     */
    private Integer type;

    /**
     * 状态，1：正常，0：冻结
     */
    private Integer status;

    /**
     * 权限在当前模块下的顺序，由小到大
     */
    private Integer sort;

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
     * 获取权限码
     *
     * @return code - 权限码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置权限码
     *
     * @param code 权限码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取权限名称
     *
     * @return name - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取权限所在的权限模块id
     *
     * @return acl_module_id - 权限所在的权限模块id
     */
    public Integer getAclModuleId() {
        return aclModuleId;
    }

    /**
     * 设置权限所在的权限模块id
     *
     * @param aclModuleId 权限所在的权限模块id
     */
    public void setAclModuleId(Integer aclModuleId) {
        this.aclModuleId = aclModuleId;
    }

    /**
     * 获取请求的url, 可以填正则表达式
     *
     * @return url - 请求的url, 可以填正则表达式
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置请求的url, 可以填正则表达式
     *
     * @param url 请求的url, 可以填正则表达式
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取类型，1：菜单，2：按钮，3：其他
     *
     * @return type - 类型，1：菜单，2：按钮，3：其他
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型，1：菜单，2：按钮，3：其他
     *
     * @param type 类型，1：菜单，2：按钮，3：其他
     */
    public void setType(Integer type) {
        this.type = type;
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
     * 获取权限在当前模块下的顺序，由小到大
     *
     * @return sort - 权限在当前模块下的顺序，由小到大
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置权限在当前模块下的顺序，由小到大
     *
     * @param sort 权限在当前模块下的顺序，由小到大
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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