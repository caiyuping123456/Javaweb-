package com.chuyu.servlet.admin;

import com.chuyu.bean.DishListVO;
import com.chuyu.dao.DishListUtils;
import com.chuyu.server.DishListServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminDishManage")
public class AdminDishManage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //�������еĶ���
        List<DishListVO> dishListVOs = DishListServer.selectAllDish();
        req.getSession().setAttribute("dishListVO",dishListVOs);
        //��ת������Ա��������ҳ��
        req.getRequestDispatcher("/adminPage/admin_dishManage.jsp").forward(req,resp);
    }
}
