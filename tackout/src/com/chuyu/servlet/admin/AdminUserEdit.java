package com.chuyu.servlet.admin;

import com.chuyu.bean.User;
import com.chuyu.server.UserServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminUserEdit")
public class AdminUserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = UserServer.selectUserList();
        req.getSession().setAttribute("userList",list);
        req.getRequestDispatcher("/adminPage/admin_userEdit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("dish_name");
        List<User> list = UserServer.selectUserByUserName(userName);
        req.getSession().setAttribute("userList",list);
        req.getRequestDispatcher("/adminPage/admin_userEdit.jsp").forward(req,resp);
    }
}
