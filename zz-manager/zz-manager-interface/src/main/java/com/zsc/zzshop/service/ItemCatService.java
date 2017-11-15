package com.zsc.zzshop.service;

import com.zsc.zzshop.common.dto.TreeNode;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/15
 * Time: 9:22
 * Version:V1.0
 */
public interface ItemCatService {
    List<TreeNode> listItemCats(Long parentId);
}
