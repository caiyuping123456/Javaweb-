package com.chuyu.bean;

public class DishVO extends Dish{
    private int num;
    String dishListid;
    private int userid;

    public DishVO(int dishid, String dishname, double price, String img, String describes, int num, String dishListid,int userid) {
        super(dishid, dishname, price, img, describes);
        this.num = num;
        this.dishListid = dishListid;
        this.userid=userid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDishListid() {
        return dishListid;
    }

    public void setDishListid(String dishListid) {
        this.dishListid = dishListid;
    }
}
