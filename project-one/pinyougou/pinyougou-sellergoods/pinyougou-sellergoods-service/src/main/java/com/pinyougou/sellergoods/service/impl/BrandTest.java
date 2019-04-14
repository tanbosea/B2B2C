package com.pinyougou.sellergoods.service.impl;

import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:spring/applicationContext*.xml"})
public class BrandTest {
    @Autowired
    TbBrandMapper tbBrandMapper;
    @Test
    public void testCRUD() {
        List<TbBrand> list = tbBrandMapper.selectByExample(null);
        System.out.println(list);
    }
    }
