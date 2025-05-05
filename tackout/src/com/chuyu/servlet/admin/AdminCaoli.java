package com.chuyu.servlet.admin;


import com.chuyu.server.DishListServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admincaoli")
public class AdminCaoli extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("order_id");
        int status = Integer.parseInt(req.getParameter("status"));
        DishListServer.updateDishList(orderId,status);
        req.getRequestDispatcher("/adminDishManage").forward(req,resp);
    }
}
