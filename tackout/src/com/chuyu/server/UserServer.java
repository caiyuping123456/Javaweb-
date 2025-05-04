package com.chuyu.server;

import com.chuyu.bean.Dish;
import com.chuyu.bean.User;
import com.chuyu.dao.DishCartUtils;
import com.chuyu.dao.DishUtils;
import com.chuyu.dao.UserUtils;

import java.util.List;

public class UserServer {
    public static boolean userEdit(User user){
        return UserUtils.userEdit(user);
    }

    public static boolean passwordEdit(User user, String newPassword,String oldPassword) {
        if(UserUtils.passwordBoolean(user,oldPassword)){
           user.setPassword(newPassword);
           return UserUtils.passwordEdit(user);
        }
        return false;

    }

///用户购物车添加
    public static void addDishCart(Integer id, int dishid) {
        //查询购物车里是否有没有菜品
        boolean exists = DishCartUtils.isExists(id,dishid);
        if(exists){
//            购物车数量加一，
        }else{
            //根据菜品id查菜品
            Dish dish = DishUtils.selectByDishId(dishid);
        }
    }

    public static List<User> selectUserList() {
        return UserUtils.selectUserList();
    }

    public static User userInfo(int userId) {
        return UserUtils.selectByUserId(userId);
    }

    public static boolean deleteUser(int userId) {
        return UserUtils.deleteUser(userId);
    }

    public static List<User> selectUserByUserName(String userName) {
        return UserUtils.selectUserByUserName(userName);
    }
}
