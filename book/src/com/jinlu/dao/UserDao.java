package com.jinlu.dao;

import com.jinlu.pojo.User;

import java.sql.Connection;

public interface UserDao {



    /**
     * 注册的时调用这个方法，判断的注册的这个用户名是否存在
     * 根据用户名查询用户信息
     * @param conn   连接对象
     * @param username  用户名
     * @return 返回null,就没有这个 对象反之亦然
     */
    public User queryUserByUsername(Connection conn,String username);

    /**
     * 将注册的用户保存到数据库
     * @param user  用户对象
     * @return   返回值为1 表示成功
     * @throws Exception
     */
    public int saveUser(Connection conn,User user)throws Exception;

    /**
     * 登录的方法
     * @param conn
     * @param username  用户名
     * @param password  用户密码
     * @return  有返回对象证明，登录成功 返回值为null证明登录失败
     * @throws Exception
     */
    public User queryUserByusernameAndpassword(Connection conn,String username,String password)throws Exception;
}
