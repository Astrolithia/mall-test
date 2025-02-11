package com.qvtu.mallbackend.service.impl;

import com.qvtu.mallbackend.mapper.MerchantMapper;
import com.qvtu.mallbackend.pojo.Merchant;
import com.qvtu.mallbackend.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
