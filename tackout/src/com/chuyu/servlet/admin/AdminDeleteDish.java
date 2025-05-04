package com.chuyu.servlet.admin;

import com.chuyu.server.DishServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delsteDish")
public class AdminDeleteDish extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dishid = Integer.parseInt(req.getParameter("dishId"));
        DishServer.deleteDish(dishid);
        req.getRequestDispatcher("/adminDishEdit").forward(req,resp);
    }
}
