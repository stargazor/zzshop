package com.zsc.zzshop.service;

import com.zsc.zzshop.pojo.po.TbContent;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/23
 * Time: 21:06
 * Version:V1.0
 */
public interface ContentService {
    List<TbContent> listContentByCid(Long id);
}
