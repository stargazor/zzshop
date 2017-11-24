package com.zsc.zzshop.service.impl;


import com.zsc.zzshop.common.jedis.JedisClient;
import com.zsc.zzshop.common.util.JsonUtils;
import com.zsc.zzshop.dao.TbContentMapper;
import com.zsc.zzshop.pojo.po.TbContent;
import com.zsc.zzshop.pojo.po.TbContentExample;
import com.zsc.zzshop.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/23
 * Time: 21:06
 * Version:V1.0
 */
@Service
public class ContentServiceImpl implements ContentService{
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbContentMapper tbContentDao;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public List<TbContent> listContentByCid(Long id) {
        List<TbContent> list=null;
        //查询缓存
        try {
            String json = jedisClient.hget("roundList", id + "");
            if(StringUtils.isNotBlank(json)){
                return JsonUtils.jsonToList(json,TbContent.class);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        //主体业务
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        list=tbContentDao.selectByExample(example);
        //存入缓存
        try{
            jedisClient.hset("roundList",id+"",JsonUtils.objectToJson(list));
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }
}
