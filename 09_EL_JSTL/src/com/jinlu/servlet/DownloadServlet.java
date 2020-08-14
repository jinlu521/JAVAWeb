package com.jinlu.servlet;

import org.apache.commons.io.IOUtils;
import org.omg.CORBA.SetOverrideType;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class DownloadServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取要下载的文件名
        String download ="2.jpg";
        //获取上下问对象
        ServletContext servletContext = getServletContext();
        // 发送之前返回数据
        String mimeType = servletContext.getMimeType("/file/" + download);
        System.out.println(mimeType);
        //设置回传的的类型
        response.setContentType(mimeType);

        //设置响应的报文
        //response.setHeader("Content-Disposition", "attachment; filename=" + download);
        response.setHeader("Content-Disposition","attachment:filename="+download);

        // 获取这个图片的流对象
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + download);
        //得到输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 利用工具类，复制这个流
        IOUtils.copy(resourceAsStream,outputStream);
    }
}
