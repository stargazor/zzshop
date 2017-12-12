package com.zsc.zzshop.service;

import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * User: Administrator
 * Date: 2017/12/1
 * Time: 13:57
 * Version:V1.0
 */
public interface SearchItemService {
    void importAllItems() throws SolrServerException, IOException;
}
