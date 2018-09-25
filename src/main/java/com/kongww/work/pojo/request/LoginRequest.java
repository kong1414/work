package com.kongww.work.pojo.request;

import javax.validation.constraints.NotBlank;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 8:47 2018/9/25
 */
public class LoginRequest {

    @NotBlank(message = "账户不能为空")
    private String account;

    @NotBlank(message = "密码不能为空")
    private String password;

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

    @Override
    public String toString() {
        return "LoginRequest{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
