package com.chuyu.servlet.admin;

import com.chuyu.server.UserServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/adminUserDelete")
public class AdminUserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        boolean flag = UserServer.deleteUser(userId);
        req.getRequestDispatcher("/adminUserEdit").forward(req,resp);
    }
}
