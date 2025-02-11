package com.qvtu.mallbackend.mapper;

import com.qvtu.mallbackend.pojo.Merchant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MerchantMapper {
    // 新增商家
    @Insert("INSERT INTO merchant (merchant_name, contact_name, contact_phone, contact_email, store_name, " +
            "store_status, merchant_type, registration_time, audit_status, audit_time, refuse_reason, " +
            "create_user, update_user, create_time, update_time) " +
            "VALUES (#{merchantName}, #{contactName}, #{contactPhone}, #{contactEmail}, #{storeName}, " +
            "#{storeStatus}, #{merchantType}, #{registrationTime}, #{auditStatus}, #{auditTime}, #{refuseReason}, " +
            "#{createUser}, #{updateUser}, #{createTime}, #{updateTime})")
    void add(Merchant merchant);
}
