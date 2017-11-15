package com.zsc.zzshop.web;

import com.zsc.zzshop.common.dto.Order;
import com.zsc.zzshop.common.dto.Page;
import com.zsc.zzshop.common.dto.Result;
import com.zsc.zzshop.pojo.po.TbItem;
import com.zsc.zzshop.pojo.po.TbItemDesc;
import com.zsc.zzshop.pojo.vo.TbItemCustom;
import com.zsc.zzshop.pojo.vo.TbItemQuery;
import com.zsc.zzshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 19:18
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {
    private Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/item/{itemId}",method = RequestMethod.GET)
    @ResponseBody
    public TbItem getById(@PathVariable("itemId") Long itemId){
        System.out.println(itemId);
        TbItem item=itemService.getById(itemId);
        return item;
    }
    @RequestMapping("/items")
    @ResponseBody
    public Result<TbItemCustom> listItemByPage(Page page, Order order, TbItemQuery query){
        Result<TbItemCustom> list=null;
        try {
            list=itemService.getByPage(page,order,query);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping("/items/batchRemove")
    @ResponseBody
    public Integer removeItemsByIds(@RequestParam("ids[]") List<Long> ids){
        int i=0;
        try {
            i=itemService.removeByIds(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/items/batchUp")
    @ResponseBody
    public Integer upItemsByIds(@RequestParam("ids[]") List<Long> ids){
        int i=0;
        try {
            i=itemService.upByIds(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/items/batchDown")
    @ResponseBody
    public Integer downItemsByIds(@RequestParam("ids[]") List<Long> ids){
        int i=0;
        try {
            i=itemService.downByIds(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping(value = "/item",method = RequestMethod.POST)
    @ResponseBody
    public Integer addItem(TbItem tbItem, TbItemDesc tbItemDesc){
        int i=0;
        try {
            i=itemService.saveItem(tbItem,tbItemDesc);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
