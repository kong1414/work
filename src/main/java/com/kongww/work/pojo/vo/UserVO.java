package com.kongww.work.pojo.vo;


/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 20:28 2018/9/18
 */
public class UserVO {

    /**
     * 用户id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学号或者工号
     */
    private String workNo;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 手机号
     */
    private String mobilephone;
    /**
     * 用户所在部门
     */
    private Integer deptId;

    /**
     * 状态（1正常,0冻结）
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


    private String token;

    private Integer pwErrorsCount;

    public UserVO() {

    }


    public UserVO(Integer id, String name, String workNo, String mail, String mobilephone, Integer deptId, String status, String remark, Integer pwErrorsCount) {
        this.id = id;
        this.name = name;
        this.workNo = workNo;
        this.mail = mail;
        this.mobilephone = mobilephone;
        this.deptId = deptId;
        this.status = status;
        this.remark = remark;
        this.pwErrorsCount = pwErrorsCount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getPwErrorsCount() {
        return pwErrorsCount;
    }

    public void setPwErrorsCount(Integer pwErrorsCount) {
        this.pwErrorsCount = pwErrorsCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workNo='" + workNo + '\'' +
                ", mail='" + mail + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                ", deptId=" + deptId +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", token='" + token + '\'' +
                ", pwErrorsCount=" + pwErrorsCount +
                '}';
    }
}
