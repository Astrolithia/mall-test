package com.qvtu.mallbackend.pojo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Merchant {
    private Integer merchantId;       // 商家ID (主键)
    private String merchantName;      // 商家名称
    private String contactName;       // 联系人姓名
    private String contactPhone;      // 联系电话
    private String contactEmail;      // 联系邮箱
    private String storeName;         // 店铺名称
    private String storeStatus;       // 店铺状态（如审核中、正常运营、已关闭等）
    private String merchantType;      // 商家类型（如个人商家、企业商家等）
    private LocalDateTime registrationTime; // 注册时间
    private String auditStatus;       // 审核状态（如待审核、已通过、审核不通过等）
    private LocalDateTime auditTime;  // 审核时间
    private String refuseReason;      // 拒绝原因
    private Integer createUser;       // 创建人
    private Integer updateUser;       // 修改人
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间
}