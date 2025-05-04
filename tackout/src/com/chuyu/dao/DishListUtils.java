package com.chuyu.dao;

import com.chuyu.bean.DishListVO;
import com.chuyu.bean.DishVO;
import com.chuyu.bean.User;
import com.chuyu.finnal.dishStatus;
import com.chuyu.utils.jdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishListUtils {
    //   ÃÌº”dishList
    public static void addDishList(User user, double sumPrice, List<DishVO> dishList) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = jdbcUtils.getConnetion();
        String sql = "insert into dishlist (dishlistid,username, phone, address, sumprice, status, userid) values (?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,dishList.get(0).getDishListid());
            preparedStatement.setString(2,user.getUserName());
            preparedStatement.setString(3,user.getPhone());
            preparedStatement.setString(4,user.getAddress());
            preparedStatement.setDouble(5,sumPrice);
            preparedStatement.setInt(6, dishStatus.DISH_STATUS_WAITING);
            preparedStatement.setInt(7,user.getId());
            int i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection,preparedStatement,null);
        }
    }

//    ªÒ»°dishlist
    public static List<DishListVO> getDishLists(User user){
        List<DishListVO> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select * from dishlist where userid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String dishlistid = resultSet.getString("dishlistid");
                String username = resultSet.getString("username");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                double sumprice = resultSet.getDouble("sumprice");
                int status = resultSet.getInt("status");
                int userid = resultSet.getInt("userid");
                DishListVO dishListVO = new DishListVO(dishlistid, username, phone, address, sumprice, status, userid);
                list.add(dishListVO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return list;
    }
}
