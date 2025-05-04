package com.chuyu.bean;

import java.util.Objects;

public class DishCart {
    private int id;
    private String dishname;
    private double dishprice;
    private int dishnum;
    private String dishlistid;
    private int userid;
    private String img;

    @Override
    public String toString() {
        return "DishCart{" +
                "id=" + id +
                ", dishname='" + dishname + '\'' +
                ", dishprice=" + dishprice +
                ", dishnum=" + dishnum +
                ", dishlistid='" + dishlistid + '\'' +
                ", userid=" + userid +
                ", img='" + img + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishCart dishCart = (DishCart) o;
        return id == dishCart.id && Double.compare(dishprice, dishCart.dishprice) == 0 && dishnum == dishCart.dishnum && userid == dishCart.userid && Objects.equals(dishname, dishCart.dishname) && Objects.equals(dishlistid, dishCart.dishlistid) && Objects.equals(img, dishCart.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishname, dishprice, dishnum, dishlistid, userid, img);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public double getDishprice() {
        return dishprice;
    }

    public void setDishprice(double dishprice) {
        this.dishprice = dishprice;
    }

    public int getDishnum() {
        return dishnum;
    }

    public void setDishnum(int dishnum) {
        this.dishnum = dishnum;
    }

    public String getDishlistid() {
        return dishlistid;
    }

    public void setDishlistid(String dishlistid) {
        this.dishlistid = dishlistid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public DishCart(int id, String dishname, double dishprice, int dishnum, String dishlistid, int userid, String img) {
        this.id = id;
        this.dishname = dishname;
        this.dishprice = dishprice;
        this.dishnum = dishnum;
        this.dishlistid = dishlistid;
        this.userid = userid;
        this.img = img;
    }
}
