package com.qvtu.mallbackend.controller;

import com.qvtu.mallbackend.pojo.Merchant;
import com.qvtu.mallbackend.pojo.PageBean;
import com.qvtu.mallbackend.pojo.Result;
import com.qvtu.mallbackend.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public Result<PageBean<Merchant>> listMerchants(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String storeStatus,
            @RequestParam(required = false) String merchantType) {
        PageBean<Merchant> pb = merchantService.list(pageNum, pageSize, storeStatus, merchantType);
        return Result.success(pb);
    }

    @GetMapping("/detail")
    public Result<Merchant> detail(@RequestParam Integer merchantId) {
        Merchant m = merchantService.findById(merchantId);
        return Result.success(m);
    }
}
