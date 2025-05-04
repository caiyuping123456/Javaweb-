package com.chuyu.servlet.admin;

import com.chuyu.bean.Dish;
import com.chuyu.server.DishServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/adminDishTail")
public class AdminDishTail extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dishId = Integer.parseInt(req.getParameter("dishId"));
        Dish dish = DishServer.getDishTail(dishId);
        req.getSession().setAttribute("dish",dish);
        req.getRequestDispatcher("/adminPage/admin_dishtail.jsp").forward(req,resp);
    }
}
