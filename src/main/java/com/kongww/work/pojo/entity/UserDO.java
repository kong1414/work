package com.kongww.work.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最后一次登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    private String token;

    @Column(name = "token_take_effect_time")
    private Date tokenTakeEffectTime;

    @Column(name = "token_age")
    private Integer tokenAge;

    /**
     * 密码错误次数
     */
    @Column(name = "pw_errors_count")
    private Integer pwErrorsCount;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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
     * 获取最后一次登录时间
     *
     * @return last_login_time - 最后一次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后一次登录时间
     *
     * @param lastLoginTime 最后一次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
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
     * 获取密码错误次数
     *
     * @return pw_errors_count - 密码错误次数
     */
    public Integer getPwErrorsCount() {
        return pwErrorsCount;
    }

    /**
     * 设置密码错误次数
     *
     * @param pwErrorsCount 密码错误次数
     */
    public void setPwErrorsCount(Integer pwErrorsCount) {
        this.pwErrorsCount = pwErrorsCount;
    }
}