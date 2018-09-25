package com.kongww.work.pojo.request;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 8:28 2018/9/25
 */
public class RegisterRequest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
