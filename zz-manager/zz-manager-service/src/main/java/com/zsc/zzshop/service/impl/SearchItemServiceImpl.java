package com.zsc.zzshop.service.impl;

import com.zsc.zzshop.dao.TbItemCustomMapper;
import com.zsc.zzshop.pojo.vo.TbSearchItemCustom;
import com.zsc.zzshop.service.SearchItemService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SearchItemServiceImpl implements SearchItemService {

    @Autowired
    private TbItemCustomMapper tbItemMapperCustom;

    @Autowired
    private SolrServer solrServer;

    @Override
    public void importAllItems() throws SolrServerException, IOException {
        //采集数据
        List<TbSearchItemCustom> list = tbItemMapperCustom.getSearchItemList();

        //采集数据遍历
        for (TbSearchItemCustom searchItem : list) {
            //拿到solr的文档域
            SolrInputDocument document = new SolrInputDocument();
            //向文档对象中添加域：对应schema.xml配置文件中的域名
            document.addField("id", searchItem.getId());
            document.addField("item_title", searchItem.getTitle());
            document.addField("item_sell_point", searchItem.getSellPoint());
            document.addField("item_price", searchItem.getPrice());
            document.addField("item_image", searchItem.getImage());
            document.addField("item_category_name", searchItem.getCatName());
            //写入索引库
            solrServer.add(document);
        }
        solrServer.commit();
    }
}