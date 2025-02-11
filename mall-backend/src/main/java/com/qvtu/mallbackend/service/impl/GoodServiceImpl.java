package com.qvtu.mallbackend.service.impl;

import com.qvtu.mallbackend.mapper.GoodMapper;
import com.qvtu.mallbackend.pojo.Good;
import com.qvtu.mallbackend.pojo.Merchant;
import com.qvtu.mallbackend.pojo.PageBean;
import com.qvtu.mallbackend.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public PageBean<Good> list(Integer pageNum, Integer pageSize, String title, Integer categoryId, String aliveStatus, String auditStatus) {
        // 计算分页偏移量
        int offset = (pageNum - 1) * pageSize;

        // 查询当前页数据
        List<Good> goods = goodMapper.list(offset, pageSize, title, categoryId, aliveStatus, auditStatus);

        // 查询总条数
        Long total = goodMapper.count(title, categoryId, aliveStatus, auditStatus);

        // 封装分页结果
        PageBean<Good> pb = new PageBean<>();
        pb.setTotal(total);
        pb.setItems(goods);
        return pb;
    }

    @Override
    public Good findById(Integer goodsId) {
        return goodMapper.findById(goodsId);
    }

    @Override
    public void update(Good good) {
        goodMapper.update(good);
    }
}
