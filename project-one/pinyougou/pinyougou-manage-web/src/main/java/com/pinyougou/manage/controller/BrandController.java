package com.pinyougou.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.Msg;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/brand")

@CrossOrigin(origins = {"http://localhost:63342", "null"})
public class BrandController {
    @Reference(timeout = 6000,retries = 5)
    private BrandService brandService;

    @GetMapping("/findAll")
    public  List<TbBrand> findAll(){
        return  brandService.getAll();
    }
    @GetMapping("/testPage")
    public Msg testPage(@RequestParam(value = "page", defaultValue =
            "1")Integer page,
                        @RequestParam(value = "rows", defaultValue =
                                "10")Integer rows){
        return  brandService.testPage(page,rows );
    }
    @PostMapping("/add.do")
    public Msg addBrand(@RequestBody TbBrand tbBrand){

        return brandService.add(tbBrand);
    }
    @GetMapping("/findOne")
    public Msg findOne(Long id){
        return brandService.findOne(id);
    }
    @PostMapping("/update")
    public Msg update(@RequestBody TbBrand tbBrand){
          return brandService.update(tbBrand);
    }
    @GetMapping("/delete")
    public Msg delete(Long[] ids){
        for (Long id:ids)
        {brandService.delete(id);}
        return Msg.success();
    }
}