package com.chuyu.servlet.user;

import com.chuyu.bean.Dish;
import com.chuyu.bean.DishVO;
import com.chuyu.bean.User;
import com.chuyu.dao.DishUtils;
import com.chuyu.server.UserServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.storeconfig.StoreFactoryRule;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/userCart")
public class UserCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/userPage/user_dishcart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dishid = Integer.parseInt(req.getParameter("dishid"));
        User user = (User) req.getSession().getAttribute("user");
        Dish dish = DishUtils.selectByDishId(dishid);
        HashMap<String, List<DishVO>> dishMap = (HashMap<String, List<DishVO>>) req.getSession().getAttribute("dishMap");
        System.out.println(dishMap);
        if(dishMap.get(user.getId()+"") == null || dishMap.get(user.getId()+"").isEmpty()){
            // ��ȡ��ǰʱ��
            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

            // ��ʽ����ǰʱ��Ϊ�ַ�������ȷ������
            String timestampPart = formatter.format(now);

            // ���UUID��һ������Ϊ�����Ψһ�Ա���
            String uuidPart = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
            uuidPart = uuidPart.substring(0, 8); // ȡǰ8λ

            // ���ʱ������ֺ�UUID�������ɶ�����
            String dishListid = (timestampPart + uuidPart);
            DishVO dishVO = new DishVO(dish.getDishid(),dish.getDishname(), dish.getPrice(), dish.getImg(), dish.getDescribes(),1, dishListid,user.getId());
            dishMap.put(user.getId()+"",new ArrayList<>());
            dishMap.get(user.getId()+"").add(dishVO);

            req.getSession().setAttribute("dishMap", dishMap);
            req.getRequestDispatcher("/userPage/user_index.jsp").forward(req,resp);
            return;
        }
        List<DishVO> dishVOS = dishMap.get(user.getId() + "");
        boolean flag = false;
        for(DishVO dishVO : dishVOS){
            if(dishVO.getDishid() == dishid){
                dishVO.setNum(dishVO.getNum()+1);
                flag = true;
                break;
            }
        }
        if(!flag){
            DishVO dishVO = new DishVO(dish.getDishid(),dish.getDishname(),
                    dish.getPrice(), dish.getImg(), dish.getDescribes(),1,
                    dishMap.get(user.getId()+"").get(0).getDishListid() ,user.getId());
            dishMap.get(user.getId()+"").add(dishVO);
        }
        req.getSession().setAttribute("dishMap", dishMap);
        req.getRequestDispatcher("/userPage/user_index.jsp").forward(req,resp);
    }
}
