package com.zsc.zzshop.service.impl;

import com.zsc.zzshop.common.dto.TreeNode;
import com.zsc.zzshop.dao.TbItemCatMapper;
import com.zsc.zzshop.pojo.po.TbItemCat;
import com.zsc.zzshop.pojo.po.TbItemCatExample;
import com.zsc.zzshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.font.TextHitInfo;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/15
 * Time: 9:23
 * Version:V1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemCatMapper itemCatDao;

    @Override
    public List<TreeNode> listItemCats(Long parentId) {
        List<TreeNode> list=null;
        try {
            list=new ArrayList<>();
            TbItemCatExample example=new TbItemCatExample();
            TbItemCatExample.Criteria criteria=example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            List<TbItemCat> tbItemCats = itemCatDao.selectByExample(example);
            for (int i=0;i<tbItemCats.size();i++){
                TreeNode treeNode=new TreeNode();
                treeNode.setId(tbItemCats.get(i).getId());
                treeNode.setText(tbItemCats.get(i).getName());
                treeNode.setState(tbItemCats.get(i).getIsParent() ? "closed":"open");
                list.add(treeNode);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return  list;
    }
}
