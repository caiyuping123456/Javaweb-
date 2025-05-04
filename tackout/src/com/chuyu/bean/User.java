package com.chuyu.bean;

import java.util.Objects;

public class User {
    //用户id
    private Integer id;
    //用户名
    private String userName;
    //用户电话
    private String phone;
    //用户地址
    private String address;
    private String password;

    public User(int id, String userName, String phone, String address) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //标记
    private boolean flag;

    public User(String name, String phone, String address, String password) {
        this.userName = name;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return flag == user.flag && Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(phone, user.phone) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, phone, address, flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public User(Integer id, String userName, String phone, String address, boolean flag) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
        this.flag=flag;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public User() {
    }
}
