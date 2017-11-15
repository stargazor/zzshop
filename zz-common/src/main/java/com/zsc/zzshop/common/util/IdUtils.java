package com.zsc.zzshop.common.util;

import java.util.Random;

/**
 * User: Administrator
 * Date: 2017/11/15
 * Time: 14:10
 * Version:V1.0
 */
public class IdUtils {

    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }
}
