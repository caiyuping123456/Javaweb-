package com.chuyu.dao;

import com.chuyu.bean.Dish;
import com.chuyu.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishUtils {
    //菜品查询
    public static List<Dish> selectDishs(){
        List<Dish> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select * from dishs";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int dishid = resultSet.getInt("dishid");
                String dishname = resultSet.getString("dishname");
                double price = resultSet.getDouble("price");
                String img = resultSet.getString("img");
                String describes = resultSet.getString("describes");
                Dish dish = new Dish(dishid,dishname,price,img,describes);
//                System.out.println(dish);
                list.add(dish);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

//    根据dishid查菜品
    public static Dish selectByDishId(int dishid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select * from dishs where dishid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dishid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("dishid");
                String dishname = resultSet.getString("dishname");
                double price = resultSet.getDouble("price");
                String img = resultSet.getString("img");
                String describes = resultSet.getString("describes");
                return new Dish(id,dishname, price, img,describes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    public static void delete(int dishId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "delete from dishs where dishid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dishId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.close(connection,preparedStatement,resultSet);
        }
    }

    public static List<Dish> selectDishByDishName(String dishName) {
        List<Dish> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "select * from dishs where dishname like concat('%',?,'%')";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dishName);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("dishid");
                String dishname = resultSet.getString("dishname");
                double price = resultSet.getDouble("price");
                String img = resultSet.getString("img");
                String describes = resultSet.getString("describes");
                Dish dish = new Dish(id, dishname, price, img, describes);
                list.add(dish);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(connection, preparedStatement, resultSet);
        }
        return list;
    }

    public static boolean updateDishInfo(Dish dish) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "update dishs set dishname = ?,price = ?,img = ?,describes = ? where dishid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,dish.getDishname());
            preparedStatement.setDouble(2,dish.getPrice());
            preparedStatement.setString(3,dish.getImg());
            preparedStatement.setString(4,dish.getDescribes());
            preparedStatement.setInt(5,dish.getDishid());
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

    public static boolean addDish(Dish dish) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = jdbcUtils.getConnetion();
        String sql = "insert into dishs (dishname,price,img,describes) values (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,dish.getDishname());
            preparedStatement.setDouble(2,dish.getPrice());
            preparedStatement.setString(3,dish.getImg());
            preparedStatement.setString(4,dish.getDescribes());
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
}
