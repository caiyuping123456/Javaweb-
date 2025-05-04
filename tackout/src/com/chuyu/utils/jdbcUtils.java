package com.chuyu.utils;


import java.sql.*;
import java.util.ResourceBundle;

public class jdbcUtils {

    private static String username;
    private static String password;
    private static String url;


    static {
        ResourceBundle messages = ResourceBundle.getBundle("com.chuyu.jdbc");
        username = messages.getString("jdbc.username");
        password = messages.getString("jdbc.password");
        url = messages.getString("jdbc.url");
        String driver = messages.getString("jdbc.class");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnetion(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
