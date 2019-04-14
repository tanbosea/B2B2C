package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.common.Msg;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements  BrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;
    @Override
    public  List<TbBrand> getAll(){
            return  tbBrandMapper.selectByExample(null);
    }
    @Override
    public Msg testPage(Integer page, Integer row){
        PageHelper.startPage(page,row);
        List<TbBrand> list=tbBrandMapper.selectByExample(null);
        PageInfo<TbBrand> pageInfo=new PageInfo(list,row);
        return Msg.success().add("PageInfo",pageInfo);
    }
    @Override
    public Msg add(TbBrand tbBrand){
        try {
            tbBrandMapper.insert(tbBrand);
            return Msg.success();
        }
        catch (Exception e){
            return Msg.fail();
        }

    }
    @Override
    public Msg findOne(Long id){
        return Msg.success().add("TbBrand",tbBrandMapper.selectByPrimaryKey(id));
    }
    @Override
    public Msg update(TbBrand tbBrand){
        tbBrandMapper.updateByPrimaryKey(tbBrand);
//        tbBrandMapper.updateByExample(tbBrand,null);

        return Msg.success();
    }
    @Override
    public void delete(Long id) {
            tbBrandMapper.deleteByPrimaryKey(id);
    }
    }
