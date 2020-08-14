package com.jinlu.dao.impl;

import com.jinlu.dao.UserDao;
import com.jinlu.pojo.User;

import java.sql.Connection;

public class UserDaoImpl extends BaseDao implements UserDao {


    /**
     * 注册是用来检测注册的用户名是否存在
     * @param conn   连接对象
     * @param username  用户名
     * @return
     * @throws Exception
     */
    @Override
    public User queryUserByUsername(Connection conn, String username){

        String sql = "select `id`,`username`,`password`,`email` from user where username = ?";
        return queryForOne(conn,User.class, sql, username);

    }


    /**
     * 用来保存注册的对象，插入数据库中
     * @param conn
     * @param user  用户对象
     * @return
     * @throws Exception
     */
    @Override
    public int saveUser(Connection conn, User user) throws Exception {
        String sql = " insert into user(username,password,email) values(?,?,?)";
        try {
            int update = update(conn, sql, user.getUsername(), user.getPassword(), user.getEmail());
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 用来检测登录的方法
     * @param conn
     * @param username  用户名
     * @param password  用户密码
     * @return User对象，表示登录成功，null表示登录失败
     * @throws Exception
     */
    @Override
    public User queryUserByusernameAndpassword(Connection conn, String username, String password) throws Exception {

        String sql="select * from user where username=? and password=?";
        try {
            User user = queryForOne(conn, User.class, sql, username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
