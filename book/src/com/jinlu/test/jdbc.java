package com.jinlu.test;

import com.jinlu.utils.Jdbcutils;

import java.sql.Connection;

public class jdbc {

    public static void main(String[] args) {
        Connection connection = Jdbcutils.getConnection();

        System.out.println(connection);
    }

}
