package com.jinlu.servlet;

import com.sun.org.apache.xpath.internal.operations.String;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
      //首先先判断上传的数据是否是多段数据,只有多段数据才是上传的
        boolean b = ServletFileUpload.isMultipartContent(request);
        if ( b ){
            //创建FileItemFactoty工厂实现类
            FileItemFactory fif = new DiskFileItemFactory();
            //创建用于解析上传数据逇工具类ServletFileUpload
            ServletFileUpload fileUpload = new ServletFileUpload(fif);
            //解析上传的数据，得到每一个表单项
            try {
                List<FileItem> list = fileUpload.parseRequest(request);
                    //循环判断，每一个表单项，是普通类型，还是上传文件
                for (FileItem fileItem : list) {

                    if (fileItem.isFormField()){
                        // true就是普通类型
                        System.out.println("表单项的name属性值"+fileItem.getFieldName());
                        //参数utf-8解决乱码问题
                        System.out.println("表单项的value属性值"+fileItem.getString("utf-8"));
                    }else{
                        //上传的文件
                        System.out.println("表单的name属性值:"+fileItem.getFieldName());
                        System.out.println("上传你的文件名"+fileItem.getName());



                        fileItem.write(new File("E:\\image\\" + fileItem.getName()));
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }



    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
