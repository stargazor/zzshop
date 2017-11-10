package com.zsc.zzshop.service.impl;

import com.zsc.zzshop.common.dto.Page;
import com.zsc.zzshop.common.dto.Result;
import com.zsc.zzshop.dao.TbItemCustomMapper;
import com.zsc.zzshop.dao.TbItemMapper;
import com.zsc.zzshop.pojo.po.TbItem;
import com.zsc.zzshop.pojo.vo.TbItemCustom;
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
    public Result<TbItemCustom> getByPage(Page page) {
        Result<TbItemCustom> result=null;
        try {
            result=new Result<TbItemCustom>();
            int countItems = itemCustomDao.countItems();
            result.setTotal(countItems);
            List<TbItemCustom> list = itemCustomDao.listItemByPage(page);
            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }
}
