package com.kongww.work.pojo.vo;

/**
 * @Author: QiuGuanLin
 * @Description: 登陆类型
 * 0为全部
 * 1为姓名登陆
 * 2为学号工号登陆
 * 3为邮箱登陆
 * 4为电子邮件登陆
 * @Date: 0:54 2018/9/23
 */
public enum LoginType {


    /**
     * 全部登陆
     */
    LoginByAllType(0),
    /**
     * 姓名登陆
     */
    LoginByName(1),
    /**
     * 学号工号登陆
     */
    LoginByWorkNo(2),
    /**
     * 邮箱登陆
     */
    LoginByMail(3),
    /**
     * 电子邮件登陆
     */
    LoginByMobilephone(4);

    private Integer code;

    LoginType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
