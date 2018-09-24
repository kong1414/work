package com.kongww.work.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "stock_list")
public class StockListDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 产品名字
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 仓库id
     */
    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @Column(name = "warehouse_name")
    private String warehouseName;

    /**
     * 单价
     */
    @Column(name = "unit_price")
    private Long unitPrice;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 进货时间
     */
    @Column(name = "purchase_time")
    private Date purchaseTime;

    /**
     * 进货人
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 进货人姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 备注
     */
    private String remark;

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
     * 获取产品id
     *
     * @return product_id - 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取产品名字
     *
     * @return product_name - 产品名字
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名字
     *
     * @param productName 产品名字
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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
     * @return warehouse_name
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * @param warehouseName
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    /**
     * 获取单价
     *
     * @return unit_price - 单价
     */
    public Long getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置单价
     *
     * @param unitPrice 单价
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
     * 获取进货时间
     *
     * @return purchase_time - 进货时间
     */
    public Date getPurchaseTime() {
        return purchaseTime;
    }

    /**
     * 设置进货时间
     *
     * @param purchaseTime 进货时间
     */
    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    /**
     * 获取进货人
     *
     * @return user_id - 进货人
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置进货人
     *
     * @param userId 进货人
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取进货人姓名
     *
     * @return user_name - 进货人姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置进货人姓名
     *
     * @param userName 进货人姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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
}