package com.chuyu.servlet.user;

import com.chuyu.bean.User;
import com.chuyu.server.UserServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/userPassword")
public class UserPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/userPage/password.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        User user = (User) req.getSession().getAttribute("user");
        boolean isModifySuccess = false;
        isModifySuccess = UserServer.passwordEdit(user,newPassword,oldPassword);
        if(isModifySuccess) {
            user.setPassword(newPassword);
            req.getSession().setAttribute("user", user);
        }
        req.setAttribute("modifySuccess", isModifySuccess); // 根据实际情况设置isModifySuccess的值
        req.getRequestDispatcher("/userPage/password.jsp").forward(req, resp);
    }
}
