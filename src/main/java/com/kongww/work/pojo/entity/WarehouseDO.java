package com.kongww.work.pojo.entity;

import javax.persistence.*;

@Table(name = "warehouse")
public class WarehouseDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 仓库名
     */
    private String name;

    /**
     * 仓库地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 启用状态（1为启用 0为不启用）
     */
    private Integer status;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取仓库名
     *
     * @return name - 仓库名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置仓库名
     *
     * @param name 仓库名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取仓库地址
     *
     * @return address - 仓库地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置仓库地址
     *
     * @param address 仓库地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取启用状态（1为启用 0为不启用）
     *
     * @return status - 启用状态（1为启用 0为不启用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置启用状态（1为启用 0为不启用）
     *
     * @param status 启用状态（1为启用 0为不启用）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}