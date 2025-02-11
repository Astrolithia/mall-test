package com.qvtu.mallbackend.controller;

import com.qvtu.mallbackend.pojo.Merchant;
import com.qvtu.mallbackend.pojo.Result;
import com.qvtu.mallbackend.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    // 新增商家
    @PostMapping("/add")
    public Result add(@RequestBody Merchant merchant) {
        merchantService.add(merchant);
        return Result.success("商家新增成功");
    }
}
