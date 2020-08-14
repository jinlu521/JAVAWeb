package com.jinlu.service.impl;


import com.jinlu.dao.UserDao;
import com.jinlu.dao.impl.UserDaoImpl;
import com.jinlu.pojo.User;
import com.jinlu.service.UserService;
import com.jinlu.utils.Jdbcutils;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao uerdao=new UserDaoImpl();

    @Override
    public void registUser(User user){
        Connection conn = Jdbcutils.getConnection();
        try {
            int i = uerdao.saveUser(conn, user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Jdbcutils.close(conn);
        }

    }

    @Override
    public User login(User user) throws Exception {
        Connection conn = Jdbcutils.getConnection();
        try {
            return uerdao.queryUserByusernameAndpassword(conn,user.getUsername(),user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                Jdbcutils.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    /**
     *
     * @param name  查询是否存在这个名字
     * @return  返回true证明有这个名字，不可以存储，返回false证明灭有这个名字
     * @throws Exception
     */
    @Override
    public boolean existsUsername(String name) {
        Connection conn = Jdbcutils.getConnection();

        try {
            User user = uerdao.queryUserByUsername(conn, name);

            if (user != null){
                return true;
            }else {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
