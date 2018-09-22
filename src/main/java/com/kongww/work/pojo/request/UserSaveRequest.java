package com.kongww.work.pojo.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserSaveRequest {

    @NotBlank(message = "姓名不能为空")
    private String name;

    private String password;

    @NotBlank(message = "学号/工号不能为空")
    private String workNo;

    private String mail;

    private String mobilephone;

    private String remark;

    private List<Integer> roleIds;

    /**
     * 数据权限 暂时没用
     */
    private List<Integer> dataPermissions;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public List<Integer> getDataPermissions() {
        return dataPermissions;
    }

    public void setDataPermissions(List<Integer> dataPermissions) {
        this.dataPermissions = dataPermissions;
    }
}
