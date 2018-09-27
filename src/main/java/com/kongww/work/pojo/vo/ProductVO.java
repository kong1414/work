package com.kongww.work.pojo.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 11:08 2018/9/25
 */
public class ProductVO {
    private Integer id;

    @Length(min = 1, max = 50, message = "产品名称应在1到50字之类")
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 产品细节
     */
    private String detail;

    /**
     * 成本单价
     */
    @DecimalMin(value = "0")
    private Long costPrice;

    /**
     * 销售单价
     */
    @Min(0)
    private Long unitPrice;

    /**
     * 数量
     */
    @Min(0)
    private Integer quantity;

    /**
     * 分类（原材料在制品产成品）
     */
    private String classify;

    /**
     * 仓库id
     */
    private Integer warehouseId;

    /**
     * 仓库名字
     */
    private String warehouseName;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Long costPrice) {
        this.costPrice = costPrice;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
