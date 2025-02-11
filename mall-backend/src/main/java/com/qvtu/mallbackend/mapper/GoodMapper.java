package com.qvtu.mallbackend.mapper;

import com.qvtu.mallbackend.pojo.Good;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper {

    // 新增商品
    @Insert("INSERT INTO `good` (goods_source, merchant_id, oneself_status, title, subtitle, " +
            "category_first_id, category_second_id, category_third_id, merchant_category_id, " +
            "goods_type_id, alive_status, brand_id, goods_label, detail_pc, detail_app, " +
            "audit_status, create_time, update_time, create_user, update_user, status, " +
            "refuse_reason, audit_time, audit_user) " +
            "VALUES (#{goodsSource}, #{merchantId}, #{oneselfStatus}, #{title}, #{subtitle}, " +
            "#{categoryFirstId}, #{categorySecondId}, #{categoryThirdId}, #{merchantCategoryId}, " +
            "#{goodsTypeId}, #{aliveStatus}, #{brandId}, #{goodsLabel}, #{detailPc}, #{detailApp}, " +
            "#{auditStatus}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser}, #{status}, " +
            "#{refuseReason}, #{auditTime}, #{auditUser})")
    void add(Good good);

    // 分页查询商品列表
    List<Good> list(int offset, Integer pageSize, String title, Integer categoryId, String aliveStatus, String auditStatus);

    // 查询商品总数
    Long count(String title, Integer categoryId, String aliveStatus, String auditStatus);
}
