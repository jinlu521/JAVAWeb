package com.jinlu.test;

import com.jinlu.pojo.User;
import com.jinlu.service.impl.UserServiceImpl;

public class UserServiceTest {
    static   UserServiceImpl us = new UserServiceImpl();
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("abc123");
        user.setPassword("abc123");

        User login = null;
        try {
            login = us.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(login);




    }
}
