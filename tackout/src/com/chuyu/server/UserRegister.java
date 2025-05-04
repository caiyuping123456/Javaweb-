package com.chuyu.server;

import com.chuyu.bean.User;
import com.chuyu.dao.UserUtils;

public class UserRegister {
    public static boolean userRegister(User user){
        return UserUtils.userAdd(user);
    }
}
