package com.pinyougou.sellergoods.service;



import com.pinyougou.common.Msg;
import com.pinyougou.pojo.TbBrand;

import java.io.Serializable;
import java.util.List;

public interface BrandService {
    public  List<TbBrand> getAll();
    public Msg testPage(Integer page, Integer row);
    public Msg add(TbBrand tbBrand);
    public Msg findOne(Long id);
    public Msg update(TbBrand tbBrand);
    public void delete(Long id);
}

