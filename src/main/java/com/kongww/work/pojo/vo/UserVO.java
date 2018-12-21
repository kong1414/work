package com.kongww.work.pojo.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 8:52 2018/9/25
 */
public class UserVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 用户名
     */
    private String username;

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
    private Date lastLoginTime;

    private String token;

    /**
     * 密码错误次数
     */
    private Integer pwErrorsCount;

    public UserVO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserVO(Integer id, String username, String mobile, String email, String remark, Date lastLoginTime, String token, Integer pwErrorsCount) {
        this.id = id;
        this.username = username;
        this.mobile = mobile;
        this.email = email;
        this.remark = remark;
        this.lastLoginTime = lastLoginTime;
        this.token = token;
        this.pwErrorsCount = pwErrorsCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getPwErrorsCount() {
        return pwErrorsCount;
    }

    public void setPwErrorsCount(Integer pwErrorsCount) {
        this.pwErrorsCount = pwErrorsCount;
    }
}
