package com.kongww.work.pojo.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/9/10 22:12
 */
public class SysLoginRequest {

    private String account;
    /**
     * 登陆类型
     * 0为全部
     * 1为姓名登陆
     * 2为学号工号登陆
     * 3为邮箱登陆
     * 4为电子邮件登陆
     */
    private int loginType;

    @NotBlank(message = "密码不能为空")
    private String password;

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
