package com.chuyu.dao;

import com.chuyu.bean.User;
import com.chuyu.utils.jdbcUtils;
import jdk.jshell.spi.SPIResolutionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserUtils {

//    查表进行登录查询
    public static User indexSelect(String username,String password){
        User user = new User();
        Connection connection = jdbcUtils.getConnetion();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from users where username = ? and password = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt("userid");
                String name = resultSet.getString("username");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                boolean flag = resultSet.getInt("flag") == 1?true:false;
                user.setId(id);
                user.setUserName(username);
                user.setPhone(phone);
                user.setAddress(address);
                user.setFlag(flag);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection, preparedStatement,resultSet);
        }
        return user;
    }
//    用户注册
    public static boolean userAdd(User user){
        if(selectByUserName(user.getUserName())) return false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = jdbcUtils.getConnetion();
        String sql = "insert into users (userid,username,phone,address,password,flag) values (null,?,?,?,?,2)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPhone());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4,user.getPassword());
            int cnt = preparedStatement.executeUpdate();
            if(cnt==1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(connection,preparedStatement,null);
        }
        return false;
    }
//    查询用户名
    public static boolean selectByUserName(String userName){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select * from users where username = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return false;
    }
    //修改用户信息
    public static boolean userEdit(User user){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "update users set username = ?,phone = ?,address = ? where userid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2,user.getPhone());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setInt(4,user.getId());
            int cnt = preparedStatement.executeUpdate();
            if(cnt==1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return false;
    }

    //密码修改
    public static boolean passwordEdit(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "update users set password = ? where userid= ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setInt(2,user.getId());
            int cnt = preparedStatement.executeUpdate();
            if(cnt==1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection, preparedStatement,resultSet);
        }
        return false;
    }

    //先判断是否密码正确
    public static boolean passwordBoolean(User user,String oldPassword) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select password from users where userid= ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                if(resultSet.getString("password").equals(oldPassword)){
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection, preparedStatement,resultSet);
        }
        return false;
    }

    public static List<User> selectUserList() {
        List<User> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select * from users where flag = 2";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String userName = resultSet.getString("username");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int id = resultSet.getInt("userid");
                User user = new User(id,userName,phone,address);
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection, preparedStatement,resultSet);
        }
        return list;
    }

    public static User selectByUserId(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select * from users where userid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String userName = resultSet.getString("username");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int id = resultSet.getInt("userid");
                return new User(id,userName,phone,address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection, preparedStatement,resultSet);
        }
        return null;
    }

    public static boolean deleteUser(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "delete from users where userid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userId);
            int i = preparedStatement.executeUpdate();
            if(i==1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection, preparedStatement,resultSet);
        }
        return false;
    }

    public static List<User> selectUserByUserName(String userName) {
        List<User> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select * from users where username = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String username = resultSet.getString("username");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int id = resultSet.getInt("userid");
                User user = new User(id,userName,phone,address);
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection, preparedStatement,resultSet);
        }
        return list;

    }
}
