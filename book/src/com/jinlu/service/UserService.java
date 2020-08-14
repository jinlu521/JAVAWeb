package com.jinlu.service;

import com.jinlu.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
     void registUser(User user);

    /**
     * 登录用户
     * @param user
     */
    User login(User user)throws Exception;

    /**
     * 检测用户名是否可用
     * @param name
     * @return 返回true表示用户名存在，返回fase表示用户名可用
     * @throws Exception
     */
    boolean existsUsername(String name);
}
