package com.jinlu.test;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    //下载图片的请求的是get请求
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //声明你要下载的图片
        String downPhoto=" ";
        // 通过上下文对象来获取图片的资源
        ServletContext servletContext = getServletContext();
        // 同时要告诉浏览器接收的的数据类型
        String mimeType = servletContext.getMimeType(" 文件路径+downphoto");
        response.setContentType(mimeType);
        //获取这个图片的流对象
        InputStream resourceAsStream = servletContext.getResourceAsStream("文件路径+downPhoto");

        // 同时设置对象头，浏览器接收的图片的处理类型,同时还需要兼容浏览器的类型

        String header = request.getHeader("User-Agent");

        if (header.contains("Firefox")){
            //火狐浏览器的编码,使用下面格式进行BASE64编码
            String str="attachment;fileName="+"=?utf-8?B"+ new BASE64Encoder().encode("中文图片名字".getBytes())+"?=";
            response.setHeader("Content-Disposition",str);
        }else{
            // 谷歌和IE的浏览器的编码，设置URL编码
            String str = "attachment;filename"+ URLEncoder.encode("图片名称","utf-8");
            response.setHeader("Content-Disposition",str);
        }
        response.setHeader("Contect-disposition","attachment;filename="+downPhoto);
        // 获取输出流对象
        ServletOutputStream outputStream = response.getOutputStream();
        // 利用jar文件下载与上传你的工具类
        // 就是相当于正常io操作，先读后写的操作，这个类直接封装好了
        IOUtils.copy(resourceAsStream,outputStream);



    }
}
