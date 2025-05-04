package com.chuyu.servlet.user;

import com.chuyu.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.chuyu.bean.DishVO;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/dishcartCaoz")
public class dishcartCaoz extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dishId = Integer.parseInt(req.getParameter("dishId"));
        int num = Integer.parseInt(req.getParameter("num"));
        User user = (User) req.getSession().getAttribute("user");
        HashMap<String, List<DishVO>> dishMap = (HashMap<String, List<DishVO>>) req.getSession().getAttribute("dishMap");
        List<DishVO> dishVOS = dishMap.get(user.getId() + "");
        if (dishVOS != null) {
            for (int i = 0; i < dishVOS.size(); i++) {
                DishVO dishVO = dishVOS.get(i);
                if (dishVO.getDishid() == dishId) {
                    int cnt = dishVO.getNum() + num;
                    if (cnt <= 0) {
                        // 删除该菜品
                        dishVOS.remove(i);
                    } else {
                        // 更新数量
                        dishVO.setNum(cnt);
                    }
                    // 更新回 session
                    req.getSession().setAttribute("dishMap", dishMap);
                    break;
                }
            }
        }
// 返回购物车页面或发送 JSON 响应
        req.getRequestDispatcher("/userPage/user_dishcart.jsp").forward(req,resp);
    }
}
