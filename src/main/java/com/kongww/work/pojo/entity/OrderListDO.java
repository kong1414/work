package com.kongww.work.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "order_list")
public class OrderListDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 货物数量
     */
    private Integer quantity;

    /**
     * 单价
     */
    @Column(name = "unit_price")
    private Long unitPrice;

    /**
     * 折扣默认100%
     */
    private Double discount;

    /**
     * 下单人
     */
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    /**
     * 下订单时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 发货人id
     */
    @Column(name = "confirmer_id")
    private Integer confirmerId;

    /**
     * 发货人
     */
    @Column(name = "confirmer_name")
    private String confirmerName;

    /**
     * 处理时间
     */
    @Column(name = "confirmer_time")
    private Date confirmerTime;

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
     * 获取货物数量
     *
     * @return quantity - 货物数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置货物数量
     *
     * @param quantity 货物数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
     * 获取折扣默认100%
     *
     * @return discount - 折扣默认100%
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * 设置折扣默认100%
     *
     * @param discount 折扣默认100%
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    /**
     * 获取下单人
     *
     * @return user_id - 下单人
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置下单人
     *
     * @param userId 下单人
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取下订单时间
     *
     * @return order_time - 下订单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置下订单时间
     *
     * @param orderTime 下订单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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
     * 获取发货人id
     *
     * @return confirmer_id - 发货人id
     */
    public Integer getConfirmerId() {
        return confirmerId;
    }

    /**
     * 设置发货人id
     *
     * @param confirmerId 发货人id
     */
    public void setConfirmerId(Integer confirmerId) {
        this.confirmerId = confirmerId;
    }

    /**
     * 获取发货人
     *
     * @return confirmer_name - 发货人
     */
    public String getConfirmerName() {
        return confirmerName;
    }

    /**
     * 设置发货人
     *
     * @param confirmerName 发货人
     */
    public void setConfirmerName(String confirmerName) {
        this.confirmerName = confirmerName == null ? null : confirmerName.trim();
    }

    /**
     * 获取处理时间
     *
     * @return confirmer_time - 处理时间
     */
    public Date getConfirmerTime() {
        return confirmerTime;
    }

    /**
     * 设置处理时间
     *
     * @param confirmerTime 处理时间
     */
    public void setConfirmerTime(Date confirmerTime) {
        this.confirmerTime = confirmerTime;
    }
}