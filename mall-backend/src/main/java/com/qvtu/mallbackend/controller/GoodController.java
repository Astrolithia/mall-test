package com.qvtu.mallbackend.controller;

import com.qvtu.mallbackend.pojo.Good;
import com.qvtu.mallbackend.pojo.PageBean;
import com.qvtu.mallbackend.pojo.Result;
import com.qvtu.mallbackend.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @PostMapping("/add")
    public Result add(@RequestBody Good good) {
        goodService.add(good);
        return Result.success("商品添加成功");
    }

    @GetMapping("/list")
    public Result<PageBean<Good>> listGoods(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String aliveStatus,
            @RequestParam(required = false) String auditStatus) {
        PageBean<Good> pb = goodService.list(pageNum, pageSize, title, categoryId, aliveStatus, auditStatus);
        return Result.success(pb);
    }

    @GetMapping("/detail")
    public Result<Good> detail(@RequestParam Integer goodsId) {
        Good g = goodService.findById(goodsId);
        return Result.success(g);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated Good good) {
        goodService.update(good);
        return Result.success("商品信息更新成功");
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer goodsId) {
        goodService.delete(goodsId);
        return Result.success("商品删除成功");
    }
}
