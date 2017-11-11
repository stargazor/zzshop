package com.zsc.zzshop.pojo.vo;

import com.zsc.zzshop.pojo.po.TbItem;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 20:59
 * Version:V1.0
 */
public class TbItemCustom extends TbItem {
    private String catName;
    private String statusName;
    private String createdString;
    private String priceView;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCreatedString() {
        return createdString;
    }

    public void setCreatedString(String createdString) {
        this.createdString = createdString;
    }

    public String getPriceView() {
        return priceView;
    }

    public void setPriceView(String priceView) {
        this.priceView = priceView;
    }
}
