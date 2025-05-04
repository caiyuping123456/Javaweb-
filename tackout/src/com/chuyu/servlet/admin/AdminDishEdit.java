package com.chuyu.servlet.admin;

import com.chuyu.bean.Dish;
import com.chuyu.server.DishServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminDishEdit")
public class AdminDishEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dish> list = DishServer.selectDishs();
        req.getSession().setAttribute("dishList",list);
        req.getRequestDispatcher("/adminPage/admin_dishEdit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dishName = req.getParameter("dish_name");
        List<Dish> list = DishServer.selectDishByDishName(dishName);
        req.getSession().setAttribute("dishList",list);
        req.getRequestDispatcher("/adminPage/admin_dishEdit.jsp").forward(req,resp);
    }
}
