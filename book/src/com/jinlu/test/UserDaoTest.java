package com.jinlu.test;


import com.jinlu.dao.impl.UserDaoImpl;
import com.jinlu.pojo.User;
import com.jinlu.utils.Jdbcutils;

import java.sql.Connection;

public class UserDaoTest {
    static UserDaoImpl userDao = new UserDaoImpl();
    public static void main(String[] args) {
        Connection conn = Jdbcutils.getConnection();
        try {
            User user = userDao.queryUserByUsername(conn, "张三");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user1 = null;
        try {
            user1 = userDao.queryUserByusernameAndpassword(conn, "张三", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user1);




    }
}