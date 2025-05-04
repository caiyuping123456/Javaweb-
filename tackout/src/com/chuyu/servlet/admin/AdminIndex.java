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

@WebServlet("/adminIndex")
public class AdminIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dish> list = DishServer.selectDishs();
        req.getSession().setAttribute("dishList",list);
        req.getRequestDispatcher("/adminPage/admin_index.jsp").forward(req,resp);
    }
}
