package com.chuyu.server;

import com.chuyu.bean.Dish;
import com.chuyu.dao.DishUtils;

import java.util.List;

public class DishServer {
    public static List<Dish> selectDishs(){
        return DishUtils.selectDishs();
    }

    public static Dish getDishTail(int dishId) {
        return DishUtils.selectByDishId(dishId);
    }
//    ²ËÆ·É¾³ý
    public static void deleteDish(int dishId){
        DishUtils.delete(dishId);
    }

    public static List<Dish> selectDishByDishName(String dishName) {
        return DishUtils.selectDishByDishName(dishName);
    }

    public static boolean updateDishInfo(Dish dish) {
        return DishUtils.updateDishInfo(dish);
    }

    public static boolean addDish(Dish dish) {
        return DishUtils.addDish(dish);
    }
}
