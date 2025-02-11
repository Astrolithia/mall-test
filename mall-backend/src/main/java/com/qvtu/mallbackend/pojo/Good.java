package com.qvtu.mallbackend.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Good {
    // 商品ID (主键)
    private Integer goodsId;

    // 商品来源
    private String goodsSource;

    // 商家ID (外键，关联到 Merchant)
    private Integer merchantId;

    // 自营状态
    private String oneselfStatus;

    // 商品标题
    private String title;

    // 商品副标题
    private String subtitle;

    // 商品一级分类ID
    private Integer categoryFirstId;

    // 商品二级分类ID
    private Integer categorySecondId;

    // 商品三级分类ID
    private Integer categoryThirdId;

    // 商家分类ID
    private Integer merchantCategoryId;

    // 商品类型ID
    private Integer goodsTypeId;

    // 上架状态
    private String aliveStatus;

    // 品牌ID
    private Integer brandId;

    // 商品标签
    private String goodsLabel;

    // PC版详情
    private String detailPc;

    // 移动版详情
    private String detailApp;

    // 审核状态
    private String auditStatus;

    // 创建时间
    private LocalDateTime createTime;

    // 修改时间
    private LocalDateTime updateTime;

    // 创建人
    private Integer createUser;

    // 修改人
    private Integer updateUser;

    // 数据状态
    private String status;

    // 拒绝原因
    private String refuseReason;

    // 审核时间
    private LocalDateTime auditTime;

    // 审核人
    private Integer auditUser;
}