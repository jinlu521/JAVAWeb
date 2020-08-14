package com.jinlu.test;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UpServlet extends HttpServlet {
    //上传图片的请求的是Post请求
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //需要导入文件上传下载的jar,其中要先判断请求的报文是否是多段的数据格式，文件的操作指定是多段是的数据个格式

        // 判断请求的报文是否是多段数据，其中request域对象中含有报文的对象
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        if (multipartContent){
            //是多段数据，
            ServletFileUpload servletFileUpload = new ServletFileUpload();
            try {
                //把请求的报文给解析成集合
                List<FileItem>list = servletFileUpload.parseRequest(request);
                // 遍历集合中的，即请求报文中具体每一请求
                for (FileItem fileitem:list) {
                    // 判断具体请求的类型，为true就是普通请求，false为上传文件的请
                    if ( fileitem.isFormField() ){
                        // 获得请求的name属性
                        String fieldName = fileitem.getFieldName();
                        // 获取请求的value值
                        String string = fileitem.getString("utf-8");
                    }else{
                        // 获取上传的文件的name属性
                        String fieldName = fileitem.getFieldName();
                        // 获取上传文件的名字
                        String name = fileitem.getName();
                        try {
                            fileitem.write(new File("服务存储长传图片的路径"+name));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
