package com.zsc.upload;

import com.zsc.zzshop.common.util.FtpUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * User: Administrator
 * Date: 2017/11/17
 * Time: 14:47
 * Version:V1.0
 */
public class FtpUploadTest {
    @Test
    public void testFtpUpload() throws IOException {
        //创建FTPClient客户端
        FTPClient ftpClient = new FTPClient();
        //创建FTP连接
        ftpClient.connect("101.132.177.223",21);
        //登录
        ftpClient.login("ftpuser","zsc123zsc");
        //读取本地文件
        FileInputStream fileInputStream = new FileInputStream(new File("d:\\image00103.jpeg"));
        //配置上传参数
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //上传文件
        ftpClient.storeFile("hello.jpg",fileInputStream);
        //关闭连接
        fileInputStream.close();
        ftpClient.logout();

    }

    @Test
    public void testFtpUtils() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("d:\\image00103.jpeg"));
        FtpUtils.uploadFile("101.132.177.223",21,"ftpuser","zsc123zsc","/home/ftpuser/www/images","/2016/09/11","hello2.jpg",fileInputStream);
    }
}
