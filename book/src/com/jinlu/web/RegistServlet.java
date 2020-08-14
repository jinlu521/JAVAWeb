package com.jinlu.web;

import com.jinlu.pojo.User;
import com.jinlu.service.UserService;
import com.jinlu.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code=request.getParameter("code");
        //检查验证码是否正确  ===写死， 要求验证码；abcde
        if ("abcde".equalsIgnoreCase(code)){
            //正确
            // 检查用户名是否存在
            boolean b = userService.existsUsername(username);
            System.out.println(b);
            if (b){
                //不可用   跳转回注册页面
                System.out.println("用户名"+username+"存在");
                request.getRequestDispatcher("/pages/user/regist.html").forward(request , response);
            }else {
                //可用调用方法保存到数据库
                User user = new User();
                user.setId(4);
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                System.out.println(user);
                userService.registUser(user);
                // 跳转页面
               // request.getRequestDispatcher("/papes/user/regist_success.html").forward(request,response);
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);


            }

        }else {
            System.out.println("验证码"+code+"错误");
            //请求转发
            request.getRequestDispatcher("/pages/user/regist.html").forward(request , response);
           // HTTP状态404-/ book / papes / user / regist / html

        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
