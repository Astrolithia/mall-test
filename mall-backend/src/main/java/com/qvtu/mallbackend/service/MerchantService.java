package com.qvtu.mallbackend.service;

import com.qvtu.mallbackend.pojo.Merchant;
import com.qvtu.mallbackend.pojo.PageBean;

public interface MerchantService {
    void add(Merchant merchant);

    PageBean<Merchant> list(Integer pageNum, Integer pageSize, String storeStatus, String merchantType);
}
