package com.kongww.work.pojo.bo;

import com.kongww.work.pojo.vo.SysUserVO;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/9/10 22:11
 */
public class SysLoginResultBO {

    private boolean success;

    private String msg;

    private SysUserVO sysUserVO;

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

    public SysUserVO getSysUserVO() {
        return sysUserVO;
    }

    public void setSysUserVO(SysUserVO sysUserVO) {
        this.sysUserVO = sysUserVO;
    }
}