package com.chuyu.servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/userTuichu")
public class UserTuichu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            // ���� session
            session.invalidate();
        }

        // �ض��򵽵�¼ҳ�����ҳ
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "index.jsp"); // �ض����¼ҳ��
    }
}
