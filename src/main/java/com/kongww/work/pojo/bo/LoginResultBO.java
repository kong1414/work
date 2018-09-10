package com.kongww.work.pojo.bo;

import com.kongww.work.pojo.entity.User;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/9/10 22:11
 */
public class LoginResultBO {

    private boolean success;

    private String msg;

    private User user;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}