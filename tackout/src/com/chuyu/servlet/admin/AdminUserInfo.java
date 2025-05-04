package com.chuyu.servlet.admin;

import com.chuyu.bean.User;
import com.chuyu.server.UserServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/adminUserInfo")
public class AdminUserInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = UserServer.userInfo(userId);
        req.getSession().setAttribute("userInfo",user);
        req.getRequestDispatcher("/adminPage/admin_userInfo.jsp").forward(req,resp);
    }
}
