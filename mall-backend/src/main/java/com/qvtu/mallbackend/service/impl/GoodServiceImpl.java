package com.qvtu.mallbackend.service.impl;

import com.qvtu.mallbackend.mapper.GoodMapper;
import com.qvtu.mallbackend.pojo.Good;
import com.qvtu.mallbackend.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    // 新增商品
    @Override
    public void add(Good good) {
        // 设置默认值
        good.setCreateTime(LocalDateTime.now());
        good.setUpdateTime(LocalDateTime.now());

        if (good.getAliveStatus() == null) {
            good.setAliveStatus("上架"); // 默认上架状态
        }
        if (good.getAuditStatus() == null) {
            good.setAuditStatus("待审核"); // 默认审核状态为待审核
        }

        // 调用Mapper保存商品
        goodMapper.add(good);
    }
}
