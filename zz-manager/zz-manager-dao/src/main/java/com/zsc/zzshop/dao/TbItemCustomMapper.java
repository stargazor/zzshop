package com.zsc.zzshop.dao;

import com.zsc.zzshop.common.dto.Order;
import com.zsc.zzshop.common.dto.Page;
import com.zsc.zzshop.pojo.vo.TbItemCustom;
import com.zsc.zzshop.pojo.vo.TbItemQuery;
import com.zsc.zzshop.pojo.vo.TbSearchItemCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/8
 * Time: 11:47
 * Version:V1.0
 */
public interface TbItemCustomMapper {
    int countItems(@Param("query") TbItemQuery query);
    List<TbItemCustom> listItemByPage(@Param("page") Page page,@Param("order") Order order,@Param("query") TbItemQuery query);
    List<TbSearchItemCustom> getSearchItemList();
}
