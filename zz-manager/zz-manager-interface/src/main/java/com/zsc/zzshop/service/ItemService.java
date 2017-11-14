package com.zsc.zzshop.service;

import com.zsc.zzshop.common.dto.Order;
import com.zsc.zzshop.common.dto.Page;
import com.zsc.zzshop.common.dto.Result;
import com.zsc.zzshop.pojo.po.TbItem;
import com.zsc.zzshop.pojo.vo.TbItemCustom;
import com.zsc.zzshop.pojo.vo.TbItemQuery;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 19:44
 * Version:V1.0
 */
public interface ItemService {
    TbItem getById(Long itemId);

    Result<TbItemCustom> getByPage(Page page, Order order, TbItemQuery query);

    int removeByIds(List<Long> ids);

    int upByIds(List<Long> ids);

    int downByIds(List<Long> ids);
}
