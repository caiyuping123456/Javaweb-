package com.chuyu.server;

import com.chuyu.bean.*;
import com.chuyu.dao.DishCartUtils;
import com.chuyu.dao.DishListUtils;

import java.util.List;
import java.util.Map;

public class DishListServer {
//    用户添加
    public static void addDishList(User user, List<DishVO> dishVOS){
        double sumprice=0;
        for (DishVO dishVO:dishVOS){
            sumprice+=dishVO.getPrice()*dishVO.getNum();
        }
        DishListUtils.addDishList(user,sumprice,dishVOS);
    }


    //用户查询
    public static List<DishListVO> UserDishList(User user){
        List<DishListVO> dishLists = DishListUtils.getDishLists(user);
        for(DishListVO dishListVO : dishLists){
            List<DishCart> dishCart = DishCartUtils.getDishCart(dishListVO.getDishlistid());
            dishListVO.setDishVOS(dishCart);
        }
        return dishLists;
    }


    public static List<DishListVO> selectAllDish() {
        return DishListUtils.selectAllDish();
    }

    public static List<DishListVO> selectDishListById(String dishListId) {
        return DishListUtils.selectDishListById(dishListId);
    }

    public static List<DishListVO> selectDishListByStatus(int status) {
        return DishListUtils.selectDishListByStatus(status);
    }

    public static void updateDishList(String orderId, int status) {
        DishListUtils.updateDishList(orderId,status);
    }
}
