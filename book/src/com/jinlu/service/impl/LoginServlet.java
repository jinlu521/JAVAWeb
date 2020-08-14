package com.jinlu.service.impl;

import com.jinlu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        User user = new User();
        user.setId(null);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(null);


        User login = null;
        try {
            login = userService.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(login);
        if ( login != null){
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request , response);
        }else {
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
