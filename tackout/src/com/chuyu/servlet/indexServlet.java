package com.chuyu.servlet;

import com.chuyu.bean.DishVO;
import com.chuyu.bean.User;
import com.chuyu.dao.UserUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//信息验证
@WebServlet("/index")
public class indexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username==null||password==null||username.length()==0||password.length()==0){
            System.out.println(123);
            response.sendRedirect("index.jsp");
            return ;
        }
        User user = UserUtils.indexSelect(username, password);
        if(user==null) response.sendRedirect("register.jsp");
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        if(user.isFlag()){//管理
            request.getRequestDispatcher("/adminIndex").forward(request,response);
        }else{
            HashMap<String, List<DishVO>> dishMap = new HashMap<>();
            dishMap.put(user.getId()+"", new ArrayList<>());
            session = request.getSession();
            session.setAttribute("dishMap", dishMap);
            request.getRequestDispatcher("/userIndex").forward(request,response);
        }
    }
}
