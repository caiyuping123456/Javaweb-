package com.chuyu.servlet.user;

import com.chuyu.bean.User;
import com.chuyu.server.UserRegister;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet("/register")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse responsep) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        User user = new User(name,phone,address,password);
        boolean resule = UserRegister.userRegister(user);
        if(resule){
            request.setAttribute("msg", "×¢²á³É¹¦£¬ÇëµÇÂ¼£¡");
            request.getRequestDispatcher("index.jsp").forward(request,responsep);
        }else{
            request.setAttribute("failMsg", "ÓÃ»§ÃûÖØ¸´£¡×¢²áÊ§°Ü£¡");
            request.getRequestDispatcher("register.jsp").forward(request,responsep);
        }
    }
}
