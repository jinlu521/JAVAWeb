package com.jinlu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
       // response.setContentType("text/html,charset=Utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\r\n");
        writer.write("  <html lang=\"en\">\r\n");
        writer.write("  <head>\r\n");
        writer.write("      <meta charset=\"UTF-8\">\r\n");
        writer.write("      <title>Title</title>\r\n");
        writer.write("  </head>\r\n");
        writer.write(" <body>\r\n");
        writer.write("    这是html页面数据 \r\n");
        writer.write("  </body>\r\n");
        writer.write("</html>\r\n");
        writer.write("\r\n");
    }
}
