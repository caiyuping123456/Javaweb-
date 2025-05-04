package com.chuyu.dao;

import com.chuyu.bean.DishCart;
import com.chuyu.bean.DishVO;
import com.chuyu.bean.User;
import com.chuyu.utils.jdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishCartUtils {
    public static boolean isExists(int userid,int dishId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select * from dishcart where dishid = ? and userid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dishId);
            preparedStatement.setInt(2, userid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int dishid = resultSet.getInt("dishid");
                if(dishId==dishid){
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return false;
    }

//    ÃÌº”dishCart
    public static void addDishCart(User user, List<DishVO> dishVOS){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "insert into dishcart (dishname,dishprice,dishnum,dishlistid,userid,img)values (?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            for(DishVO dishVO:dishVOS){
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, dishVO.getDishname());
                preparedStatement.setDouble(2,dishVO.getPrice());
                preparedStatement.setInt(3,dishVO.getNum());
                preparedStatement.setString(4,dishVO.getDishListid());
                preparedStatement.setInt(5,user.getId());
                preparedStatement.setString(6,dishVO.getImg());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(connection,preparedStatement,resultSet);
        }
    }

//    ≤È—Ø≤À∆∑
    public static List<DishCart> getDishCart(String DishListId){
        List<DishCart> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select * from dishcart where dishlistid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,DishListId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String dishname = resultSet.getString("dishname");
                double dishprice = resultSet.getDouble("dishprice");
                int dishnum = resultSet.getInt("dishnum");
                String dishlistid = resultSet.getString("dishlistid");
                int userid = resultSet.getInt("userid");
                String img = resultSet.getString("img");
                DishCart dishCart = new DishCart(id, dishname, dishprice, dishnum, dishlistid, userid, img);
                list.add(dishCart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

}