package com.kongww.work.pojo.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/9/10 22:12
 */
public class LoginRequest {

    @NotBlank(message = "{login.name.empty}")
    private String name;

    @NotBlank(message = "{login.password.empty}")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
