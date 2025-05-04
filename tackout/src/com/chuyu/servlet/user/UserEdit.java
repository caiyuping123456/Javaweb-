package com.chuyu.servlet.user;

import com.chuyu.bean.User;
import com.chuyu.server.UserServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/userEdit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/userPage/userEdit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        User user = (User) req.getSession().getAttribute("user");
        user.setUserName(username);
        user.setPhone(phone);
        user.setAddress(address);
        boolean edit = UserServer.userEdit(user);
        if(edit){
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/userPage/user_wode.jsp").forward(req,resp);
        }
    }
}
