package com.zsc.zzshop.web;

import com.zsc.zzshop.common.dto.MessageResult;
import com.zsc.zzshop.service.SearchItemService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * User: Administrator
 * Date: 2017/12/1
 * Time: 13:56
 * Version:V1.0
 */
@Controller
public class SearchItemAction {

    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping("/search/item/import")
    @ResponseBody
    public MessageResult importItemList() throws SolrServerException, IOException {

        searchItemService.importAllItems();

        MessageResult ms = new MessageResult();
        ms.setSuccess(true);
        ms.setMessage("索引导入成功");
        return ms;
    }
}