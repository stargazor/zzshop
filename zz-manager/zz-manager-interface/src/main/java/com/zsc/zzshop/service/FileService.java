package com.zsc.zzshop.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/18
 * Time: 17:24
 * Version:V1.0
 */
public interface FileService {
    Map<String,Object> uploadImage(MultipartFile upfile);
}
