package com.pinyougou.service;

import com.pinyougou.common.Msg;

import java.io.Serializable;

public interface CommonService<T> {
    /**
     *根据主键查询
     * @param id 主键
     * @return 实体对象
     */
    public Msg findOne(Serializable id);
}
