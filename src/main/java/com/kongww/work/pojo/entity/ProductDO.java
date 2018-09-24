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
    @Column(name = "`cost price`")
    private Long costPrice;

    /**
     * 销售单价
     */
    @Column(name = "unit_price")
    private Long unitPrice;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 分类（原材料在制品产成品）
     */
    private String classify;

    /**
     * 仓库id
     */
    @Column(name = "warehouse_id")
    private Integer warehouseId;

    /**
     * 仓库名字
     */
    @Column(name = "warehouse_name")
    private String warehouseName;

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
     * 获取数量
     *
     * @return quantity - 数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置数量
     *
     * @param quantity 数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    /**
     * 获取仓库id
     *
     * @return warehouse_id - 仓库id
     */
    public Integer getWarehouseId() {
        return warehouseId;
    }

    /**
     * 设置仓库id
     *
     * @param warehouseId 仓库id
     */
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * 获取仓库名字
     *
     * @return warehouse_name - 仓库名字
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * 设置仓库名字
     *
     * @param warehouseName 仓库名字
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }
}