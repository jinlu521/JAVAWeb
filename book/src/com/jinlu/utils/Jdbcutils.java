package com.jinlu.utils;






import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Jdbcutils {
    private static DruidDataSource ds;
    static {
        try {
            Properties pro=new Properties();
            InputStream res = Jdbcutils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(res);
            ds= (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static Connection getConnection(){
        DruidPooledConnection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static  void close(Connection conn){
        try {
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
