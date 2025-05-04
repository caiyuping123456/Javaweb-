package com.chuyu.bean;

import java.util.List;
import java.util.Objects;

public class DishListVO {
    private String dishlistid;
    private String username;
    private String phone;
    private String address;
    private double sumprice;
    private int status;
    private int userid;
    private List<DishCart> dishVOS;

    @Override
    public String toString() {
        return "DishListVO{" +
                "dishlistid='" + dishlistid + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", sumprice=" + sumprice +
                ", status=" + status +
                ", userid=" + userid +
                ", dishVOS=" + dishVOS +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishListVO that = (DishListVO) o;
        return Double.compare(sumprice, that.sumprice) == 0 && status == that.status && userid == that.userid && Objects.equals(dishlistid, that.dishlistid) && Objects.equals(username, that.username) && Objects.equals(phone, that.phone) && Objects.equals(address, that.address) && Objects.equals(dishVOS, that.dishVOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishlistid, username, phone, address, sumprice, status, userid, dishVOS);
    }

    public List<DishCart> getDishVOS() {
        return dishVOS;
    }

    public void setDishVOS(List<DishCart> dishVOS) {
        this.dishVOS = dishVOS;
    }

    public DishListVO(String dishlistid, String username, String phone, String address, double sumprice, int status, int userid, List<DishCart> dishVOS) {
        this.dishlistid = dishlistid;
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.sumprice = sumprice;
        this.status = status;
        this.userid = userid;
        this.dishVOS = dishVOS;
    }

    public String getDishlistid() {
        return dishlistid;
    }

    public void setDishlistid(String dishlistid) {
        this.dishlistid = dishlistid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSumprice() {
        return sumprice;
    }

    public void setSumprice(double sumprice) {
        this.sumprice = sumprice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public DishListVO(String dishlistid, String username, String phone, String address, double sumprice, int status, int userid) {
        this.dishlistid = dishlistid;
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.sumprice = sumprice;
        this.status = status;
        this.userid = userid;
    }
}
