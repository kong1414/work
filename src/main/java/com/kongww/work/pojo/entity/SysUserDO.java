package com.kongww.work.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUserDO {
    /**
     * 用户id
     */
    @Id
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer pkId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学号或者工号
     */
    @Column(name = "work_no")
    private String workNo;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 手机号
     */
    private String mobilephone;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户所在部门
     */
    @Column(name = "dept_id")
    private Integer deptId;

    /**
     * 状态（1正常,0冻结）
     */
    private String status;

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
     * token
     */
    private String token;

    @Column(name = "token_take_effect_time")
    private Date tokenTakeEffectTime;

    @Column(name = "token_age")
    private Integer tokenAge;

    @Column(name = "pw_errors_count")
    private Integer pwErrorsCount;

    /**
     * 获取用户id
     *
     * @return pk_id - 用户id
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 设置用户id
     *
     * @param pkId 用户id
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取学号或者工号
     *
     * @return work_no - 学号或者工号
     */
    public String getWorkNo() {
        return workNo;
    }

    /**
     * 设置学号或者工号
     *
     * @param workNo 学号或者工号
     */
    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }

    /**
     * 获取邮箱
     *
     * @return mail - 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮箱
     *
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobilephone - 手机号
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * 设置手机号
     *
     * @param mobilephone 手机号
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户所在部门
     *
     * @return dept_id - 用户所在部门
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置用户所在部门
     *
     * @param deptId 用户所在部门
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取状态（1正常,0冻结）
     *
     * @return status - 状态（1正常,0冻结）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（1正常,0冻结）
     *
     * @param status 状态（1正常,0冻结）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    /**
     * 获取token
     *
     * @return token - token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token
     *
     * @param token token
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * @return token_take_effect_time
     */
    public Date getTokenTakeEffectTime() {
        return tokenTakeEffectTime;
    }

    /**
     * @param tokenTakeEffectTime
     */
    public void setTokenTakeEffectTime(Date tokenTakeEffectTime) {
        this.tokenTakeEffectTime = tokenTakeEffectTime;
    }

    /**
     * @return token_age
     */
    public Integer getTokenAge() {
        return tokenAge;
    }

    /**
     * @param tokenAge
     */
    public void setTokenAge(Integer tokenAge) {
        this.tokenAge = tokenAge;
    }

    /**
     * @return pw_errors_count
     */
    public Integer getPwErrorsCount() {
        return pwErrorsCount;
    }

    /**
     * @param pwErrorsCount
     */
    public void setPwErrorsCount(Integer pwErrorsCount) {
        this.pwErrorsCount = pwErrorsCount;
    }
}