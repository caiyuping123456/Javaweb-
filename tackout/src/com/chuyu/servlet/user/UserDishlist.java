package com.chuyu.servlet.user;

import com.chuyu.bean.DishListVO;
import com.chuyu.bean.User;
import com.chuyu.server.DishListServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/userDishlist")
public class UserDishlist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取菜品列表和全部的菜品
        User user = (User) req.getSession().getAttribute("user");
        List<DishListVO> list = DishListServer.UserDishList(user);
        req.getSession().setAttribute("DishListVO", list);
        req.getRequestDispatcher("/userPage/user_wode_dishlist.jsp").forward(req,resp);
    }
}
