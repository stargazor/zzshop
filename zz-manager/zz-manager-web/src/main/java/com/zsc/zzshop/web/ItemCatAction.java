package com.zsc.zzshop.web;

import com.zsc.zzshop.common.dto.TreeNode;
import com.zsc.zzshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/15
 * Time: 9:04
 * Version:V1.0
 */
@Controller
public class ItemCatAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/itemCats",method = RequestMethod.POST)
    @ResponseBody
    public List<TreeNode> listItemCats(@RequestParam("parentId") Long parentId){
        List<TreeNode> list=null;
        try {
            list=itemCatService.listItemCats(parentId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }
}
