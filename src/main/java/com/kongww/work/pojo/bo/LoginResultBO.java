package com.kongww.work.pojo.bo;

import com.kongww.work.pojo.vo.UserVO;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/9/10 22:11
 */
public class LoginResultBO {

    private boolean success;

    private String msg;

    private UserVO userVO;

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

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }
}