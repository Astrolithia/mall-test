package com.qvtu.mallbackend.mapper;

import com.qvtu.mallbackend.pojo.Merchant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    // 分页查询商家列表
    List<Merchant> list(@Param("offset") Integer offset,
                        @Param("pageSize") Integer pageSize,
                        @Param("storeStatus") String storeStatus,
                        @Param("merchantType") String merchantType);

    // 查询商家总数
    Long count(String storeStatus, String merchantType);
}
