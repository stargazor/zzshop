package com.zsc.zzshop.service.impl;

import com.zsc.zzshop.common.dto.Order;
import com.zsc.zzshop.common.dto.Page;
import com.zsc.zzshop.common.dto.Result;
import com.zsc.zzshop.dao.TbItemCustomMapper;
import com.zsc.zzshop.dao.TbItemMapper;
import com.zsc.zzshop.pojo.po.TbItem;
import com.zsc.zzshop.pojo.po.TbItemExample;
import com.zsc.zzshop.pojo.vo.TbItemCustom;
import com.zsc.zzshop.pojo.vo.TbItemQuery;
import com.zsc.zzshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 19:45
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public Result<TbItemCustom> getByPage(Page page, Order order, TbItemQuery query) {
        Result<TbItemCustom> result=null;
        try {
            result=new Result<TbItemCustom>();
            int countItems = itemCustomDao.countItems(query);
            result.setTotal(countItems);
            List<TbItemCustom> list = itemCustomDao.listItemByPage(page,order,query);
            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int downByIds(List<Long> ids) {
        int i=0;
        try {
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            TbItem record=new TbItem();
            record.setStatus((byte) 2);
            i = itemDao.updateByExampleSelective(record, example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int upByIds(List<Long> ids) {
        int i=0;
        try {
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            TbItem record=new TbItem();
            record.setStatus((byte) 1);
            i = itemDao.updateByExampleSelective(record, example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int removeByIds(List<Long> ids) {
        int i=0;
        try {
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            TbItem record=new TbItem();
            record.setStatus((byte) 3);
            i = itemDao.updateByExampleSelective(record, example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
