package com.qvtu.mallbackend.service;

import com.qvtu.mallbackend.pojo.Good;
import com.qvtu.mallbackend.pojo.PageBean;

public interface GoodService {
    void add(Good good);

    PageBean<Good> list(Integer pageNum, Integer pageSize, String title, Integer categoryId, String aliveStatus, String auditStatus);
}
