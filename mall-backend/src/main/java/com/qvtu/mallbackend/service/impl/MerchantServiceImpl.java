package com.qvtu.mallbackend.service.impl;

import com.qvtu.mallbackend.mapper.MerchantMapper;
import com.qvtu.mallbackend.pojo.Merchant;
import com.qvtu.mallbackend.pojo.PageBean;
import com.qvtu.mallbackend.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public void add(Merchant merchant) {
        // 设置默认状态和创建时间
        merchant.setStoreStatus("正常运营");
        merchantMapper.add(merchant);
    }

    @Override
    public PageBean<Merchant> list(Integer pageNum, Integer pageSize, String storeStatus, String merchantType) {
        // 计算偏移量
        int offset = (pageNum - 1) * pageSize;

        // 查询商家列表
        List<Merchant> merchants = merchantMapper.list(offset, pageSize, storeStatus, merchantType);

        // 查询商家总数
        Long total = merchantMapper.count(storeStatus, merchantType);

        // 封装分页结果
        PageBean<Merchant> pb = new PageBean<>();
        pb.setTotal(total);
        pb.setItems(merchants);
        return pb;
    }
}
