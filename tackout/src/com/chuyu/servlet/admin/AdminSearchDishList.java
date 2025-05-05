package com.chuyu.servlet.admin;

import com.chuyu.bean.DishListVO;
import com.chuyu.finnal.dishStatus;
import com.chuyu.server.DishListServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/searchDish")
public class AdminSearchDishList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dishListId = req.getParameter("dishListId");
        List<DishListVO> dishListVOS = DishListServer.selectDishListById(dishListId);
        req.getSession().setAttribute("dishListVO", dishListVOS);
        req.getRequestDispatcher("/adminPage/admin_dishManage.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("status");
        if(parameter==null){
            req.getRequestDispatcher("/adminDishManage").forward(req,resp);
        }
        int status = Integer.parseInt(parameter);
        List<DishListVO> dishListVOS  = DishListServer.selectDishListByStatus(status);
        req.getSession().setAttribute("dishListVO", dishListVOS);
        req.getRequestDispatcher("/adminPage/admin_dishManage.jsp").forward(req,resp);
    }
}
