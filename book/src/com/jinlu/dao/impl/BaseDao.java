package com.jinlu.dao.impl;


import com.alibaba.druid.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    // 使用Dbutils操作数据库
    private QueryRunner runner = new QueryRunner();

    /**
     * update进行增删改的操作
     *
     * @return 如果返回-1表示失败，返回其他表示影响的行数
     */
    public int update(Connection conn, String sql, Object...args) {
        try {
            return runner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     *  查询返回一个javaBean的sql语句
     * @param conn  对象连接大户局库对象
     * @param type  返回的对象的类型
     * @param sql   执行的sql语句
     * @param args  sql对应的参数
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Connection conn,Class<T> type, String sql, Object... args) {

        BeanHandler<T> beanHandler = new BeanHandler<>(type);
        try {
            return runner.query(conn, sql, beanHandler, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  查询返回对个javaBean的sql语句的集合
     * @param conn
     * @param type   返回的对象类型
     * @param sql    执行的sql的语句
     * @param args   sql对象的参数
     * @param <T>    返回类型的泛型
     * @return
     */

 public <T> List<T> queryForList(Connection conn,Class<T> type,String sql,Object...args){

     BeanListHandler<T> beanListHandler = new BeanListHandler<>(type);
     try {
         return runner.query(conn, sql, beanListHandler, args);
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return null;
 }

    /**
     * 执行返回一行一列的sql语句
     * @param conn
     * @param sql  执行sql语句
     * @param args sql对应的参数值
     * @return
     */
 public Object queryForSingleValue(Connection conn,String sql,Object...args){
     ScalarHandler scalarHandler = new ScalarHandler();
     try {
         return runner.query(conn,sql,scalarHandler);
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return null;
 }

}