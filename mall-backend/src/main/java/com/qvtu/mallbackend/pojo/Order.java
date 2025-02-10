package com.qvtu.mallbackend.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private Integer orderId;       // 订单ID (主键)
    private Integer userId;        // 用户ID (外键，关联到 User)
    private Integer merchantId;    // 商家ID (外键，关联到 Merchant)
    private String orderStatus;    // 订单状态
    private String paymentStatus;  // 支付状态
    private LocalDateTime paymentTime; // 支付时间
    private BigDecimal orderTotal; // 订单总金额
    private String shippingStatus; // 配送状态
    private LocalDateTime shippingTime; // 配送时间
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间
}