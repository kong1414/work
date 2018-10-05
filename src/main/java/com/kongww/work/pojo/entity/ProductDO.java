package com.kongww.work.pojo.entity;

import javax.persistence.*;

@Table(name = "product")
public class ProductDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

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
    @Column(name = "cost_price")
    private Long costPrice;

    /**
     * 销售单价
     */
    @Column(name = "unit_price")
    private Long unitPrice;

    /**
     * 分类（原材料在制品产成品）
     */
    private String classify;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取产品细节
     *
     * @return detail - 产品细节
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置产品细节
     *
     * @param detail 产品细节
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * 获取成本单价
     *
     * @return cost price - 成本单价
     */
    public Long getCostPrice() {
        return costPrice;
    }

    /**
     * 设置成本单价
     *
     * @param costPrice 成本单价
     */
    public void setCostPrice(Long costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * 获取销售单价
     *
     * @return unit_price - 销售单价
     */
    public Long getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置销售单价
     *
     * @param unitPrice 销售单价
     */
    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 获取分类（原材料在制品产成品）
     *
     * @return classify - 分类（原材料在制品产成品）
     */
    public String getClassify() {
        return classify;
    }

    /**
     * 设置分类（原材料在制品产成品）
     *
     * @param classify 分类（原材料在制品产成品）
     */
    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }
}