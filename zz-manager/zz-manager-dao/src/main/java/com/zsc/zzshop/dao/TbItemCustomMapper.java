package com.zsc.zzshop.dao;

import com.zsc.zzshop.common.dto.Page;
import com.zsc.zzshop.pojo.vo.TbItemCustom;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/8
 * Time: 11:47
 * Version:V1.0
 */
public interface TbItemCustomMapper {
    int countItems();
    List<TbItemCustom> listItemByPage(Page page);
}
