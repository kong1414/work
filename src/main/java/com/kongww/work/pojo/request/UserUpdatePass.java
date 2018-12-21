package com.kongww.work.pojo.request;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/12/21 15:22
 * @version: 1.0
 */
public class UserUpdatePass {
    private String oldPass;

    private String newPass;

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
