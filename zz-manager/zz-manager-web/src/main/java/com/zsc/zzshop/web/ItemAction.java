package com.zsc.zzshop.web;

import com.zsc.zzshop.common.dto.Page;
import com.zsc.zzshop.common.dto.Result;
import com.zsc.zzshop.pojo.po.TbItem;
import com.zsc.zzshop.pojo.vo.TbItemCustom;
import com.zsc.zzshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
    public Result<TbItemCustom> listItemByPage(Page page){
        Result<TbItemCustom> list=null;
        try {
            list=itemService.getByPage(page);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }
}
