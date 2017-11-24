package com.zsc.zzshop.portal.web;

import com.zsc.zzshop.common.util.PropKit;
import com.zsc.zzshop.pojo.po.TbContent;
import com.zsc.zzshop.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/23
 * Time: 19:37
 * Version:V1.0
 */
@Controller
public class PortalIndexAction {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ContentService contentService;

    @RequestMapping("/")
    public String portalIndex(Model model){
        Long id= PropKit.use("ftp.properties").getLong("ftp.round");
        List<TbContent> list=null;
        try {
            list=contentService.listContentByCid(id);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        model.addAttribute("roundList",list);
        return "index";
    }
}
