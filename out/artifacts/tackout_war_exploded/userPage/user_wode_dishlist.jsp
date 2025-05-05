<%@ page import="com.chuyu.bean.DishListVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.chuyu.bean.DishCart" %><%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/28
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" rel="stylesheet">
    <title>查看订单</title>
    <style>
        body {
            font-family: 'Inter', sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .top-nav {
            background-color: #ed8936;
            color: white;
            padding: 15px 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .top-nav h1 {
            font-size: 24px;
            margin: 0;
        }

        .main-content {
            padding: 20px;
        }

        .order-list {
            margin-top: 20px;
        }

        .order-item {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }

        .order-item h3 {
            margin-bottom: 5px;
        }

        .order-item p {
            margin: 5px 0;
        }

        .dish-list {
            margin-top: 10px;
            padding-left: 20px;
        }

        .dish-list li {
            margin-bottom: 3px;
        }
        .bottom-nav {
            position: fixed;
            bottom: 0;
            left: 0;
            right: 0;
            background-color: #fff;
            border-top: 1px solid #e2e8f0;
            display: flex;
            justify-content: space-around;
            padding: 10px 0;
        }

        .bottom-nav-item {
            display: flex;
            flex-direction: column;
            align-items: center;
            color: #718096;
            text-decoration: none;
        }

        .bottom-nav-item i {
            font-size: 20px;
            margin-bottom: 4px;
        }

        .bottom-nav-item span {
            font-size: 12px;
        }

        .bottom-nav-item.active {
            color: #ed8936;
        }
    </style>
</head>

<body>
<!-- 顶部导航栏 -->
<div class="top-nav">
    <h1>查看订单</h1>
</div>

<!-- 主内容区域 -->
<div id="order-list">
    <%
        List<DishListVO> list  = (List<DishListVO>) request.getSession().getAttribute("DishListVO");

        for(DishListVO dishListVO : list){
            out.println("<div class='order-item'>");
            out.println("<h3>订单编号: " + dishListVO.getDishlistid() + "</h3>");
            out.println("<p>客户名字: " + dishListVO.getUsername() + "</p>");
            out.println("<p>客户电话: " + dishListVO.getPhone() + "</p>");
            out.println("<p>客户地址: " + dishListVO.getAddress() + "</p>");
            out.println("<p>总价: ￥" + dishListVO.getSumprice() + "</p>");
            if(dishListVO.getStatus()==0){
                out.println("<p>订单状态: " + "待接单" + "</p>");
            }else if (dishListVO.getStatus()==1){
                out.println("<p>订单状态: " + "等待配送" + "</p>");
            }else if (dishListVO.getStatus()==2){
                out.println("<p>订单状态: " + "配送中" + "</p>");
            }else{
                out.println("<p>订单状态: " + "已完成" + "</p>");
            }
            out.println("<ul class='dish-list'>");
            List<DishCart> dishCarts = dishListVO.getDishVOS();
            for(DishCart dishCart : dishCarts){
                out.println("<li>" + dishCart.getDishname() + "--- "+ dishCart.getDishprice() +"￥"+ " x " + dishCart.getDishnum() + "</li>");
            }
            out.println("</ul>");

            out.println("</div>");
        }

        request.getSession().removeAttribute("DishListVO");
    %>
</div>
<nav class="bottom-nav">
    <a href="/userIndex" class="bottom-nav-item active" id="home-btn">
        <i class="fa-solid fa-house"></i>
        <span>首页</span>
    </a>
    <a href="/userCart" class="bottom-nav-item" id="cart-btn">
        <i class="fa-solid fa-cart-shopping"></i>
        <span>购物车</span>
    </a>
    <a href="/userWode" class="bottom-nav-item" id="profile-btn">
        <i class="fa-solid fa-user"></i>
        <span>我的</span>
    </a>
</nav>

</body>

</html>
