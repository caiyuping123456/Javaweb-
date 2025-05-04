package com.chuyu.servlet.user;

import com.chuyu.bean.Dish;
import com.chuyu.bean.DishVO;
import com.chuyu.bean.User;
import com.chuyu.dao.DishCartUtils;
import com.chuyu.server.DishListServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/userOrder")
public class UserOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, List<DishVO>> dishMap = (HashMap<String, List<DishVO>>) req.getSession().getAttribute("dishMap");
        User user = ((User) req.getSession().getAttribute("user"));
        System.out.println(dishMap.get(user.getId()+""));
//        Ìí¼Ódishlist
        DishListServer.addDishList(user,dishMap.get(user.getId()+""));
//        Ìí¼Ódishcart
        DishCartUtils.addDishCart(user,dishMap.get(user.getId()+""));
        //ÒÆ³ýdishmap
        req.getSession().removeAttribute("dishMap");
        HashMap<String, List<DishVO>> Map = new HashMap<>();
        dishMap.put(user.getId()+"", new ArrayList<>());
        req.getSession().setAttribute("dishMap", dishMap);
        req.getRequestDispatcher("/userPage/user_dishcart.jsp").forward(req,resp);
    }
}
