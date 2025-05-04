package com.chuyu.servlet.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/adminTuichu")
public class AdminTuichu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            // 销毁 session
            session.invalidate();
        }

        // 重定向到登录页面或主页
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "index.jsp"); // 重定向登录页面
    }
}
