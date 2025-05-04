package com.chuyu.bean;

import java.util.Objects;

public class Dish {
    private int dishid;
    private String dishname;
    private double price;
    private String img;
    private String describes;

    public Dish(String dishname, double price, String img,String describes) {
        this.dishname=dishname;
        this.price=price;
        this.img=img;
        this.describes = describes;
    }


    @Override
    public String toString() {
        return "Dish{" +
                "dishid=" + dishid +
                ", dishname='" + dishname + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return dishid == dish.dishid && Double.compare(price, dish.price) == 0 && Objects.equals(dishname, dish.dishname) && Objects.equals(img, dish.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishid, dishname, price, img);
    }

    public int getDishid() {
        return dishid;
    }

    public void setDishid(int dishid) {
        this.dishid = dishid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Dish() {
    }

    public Dish(int dishid, String dishname, double price, String img ,String describes) {
        this.dishid = dishid;
        this.dishname = dishname;
        this.price = price;
        this.img = img;
        this.describes = describes;
    }
}
