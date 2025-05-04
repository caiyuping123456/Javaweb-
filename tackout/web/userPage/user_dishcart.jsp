<%@ page import="com.chuyu.bean.DishVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/28
  Time: 21:53
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
    <title>外卖购物车</title>
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

        .cart-item {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .cart-item img {
            width: 80px;
            height: 80px;
            object-fit: cover;
            border-radius: 4px;
            margin-right: 20px;
        }

        .cart-item-info {
            flex: 1;
        }

        .cart-item-info h3 {
            font-size: 18px;
            margin-bottom: 5px;
        }

        .cart-item-info p {
            font-size: 14px;
            color: #777;
            margin-bottom: 10px;
        }

        .cart-item-price {
            font-size: 16px;
            font-weight: bold;
            color: #ed8936;
        }

        .quantity-control {
            display: flex;
            align-items: center;
        }

        .quantity-control button {
            background-color: #ed8936;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 5px 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .quantity-control button:hover {
            background-color: #dd6b20;
        }

        .quantity-control input {
            width: 40px;
            text-align: center;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin: 0 10px;
            padding: 5px;
        }

        .total-price {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: right;
            font-size: 18px;
            font-weight: bold;
            color: #ed8936;
        }

        .submit-order {
            background-color: #ed8936;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            display: block;
            width: 100%;
            margin-top: 20px;
        }

        .submit-order:hover {
            background-color: #dd6b20;
        }

        .bottom-nav {
            position: fixed;
            bottom: 0;
            left: 0;
            right: 0;
            background-color: white;
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
    <h1>外卖购物车</h1>
</div>

<!-- 主内容区域 -->
<div class="main-content mb-16">
    <!-- 购物车商品列表 -->
    <div id="cart-items">
        <%
            // 获取 session 中的 dishMap
            HashMap<String, List<DishVO>> dishMap = (HashMap<String, List<DishVO>>) request.getSession().getAttribute("dishMap");
            double sum=0;
            if (dishMap != null && !dishMap.isEmpty()) {
                for (String userId : dishMap.keySet()) {
                    List<DishVO> dishes = dishMap.get(userId);

                    if (dishes != null && !dishes.isEmpty()) {
                        int index = 0; // 用于生成不同图片
                        for (DishVO dish : dishes) {
                            sum = sum+dish.getPrice() * dish.getNum();
        %>
                    <div class="cart-item">
                        <img src="/img/<%=dish.getImg()%>" alt="菜品图片">
                        <div class="cart-item-info">
                            <h3><%=dish.getDishname()%></h3>
                            <p><%=dish.getDescribes()%></p>
                            <div class="cart-item-price">￥<%=dish.getPrice() * dish.getNum()%></div>

                        </div>
                        <div class="quantity-control">
                            <button type="button" onclick="changeQuantity(<%=dish.getDishid()%>, -1)">-</button>
                            <input type="number" id="num_<%=dish.getDishid() %>" value="<%=dish.getNum()%>">
                            <button type="button" onclick="changeQuantity(<%=dish.getDishid()%>, 1)">+</button>
                        </div>
                    </div>
        <%
                    } // dishes 循环结束
                } // dishes 非空判断
            } // 用户 ID 循环结束
        } else {
        %>
        <p>购物车为空，请先添加菜品。</p>
        <%
            }
        %>

        <script>
            function changeQuantity(dishId, delta) {
                window.location.href = '/dishcartCaoz?dishId=' + dishId + '&num=' + delta;
            }
        </script>

    </div>
    <!-- 总价 -->
    <div class="total-price">
        总价：<span id="total-amount">￥<%=sum%></span>
    </div>
    <!-- 提交订单按钮 -->
    <button class="submit-order" onclick="submitOrder()">提交订单</button>
    <script>
        function submitOrder() {
            window.location.href = '/userOrder';
        }
    </script>

</div>

<!-- 底部导航栏 -->
<nav class="bottom-nav">
    <a href="/userIndex" class="bottom-nav-item" id="home-btn">
        <i class="fa-solid fa-house"></i>
        <span>首页</span>
    </a>
    <a href="#" class="bottom-nav-item active" id="cart-btn">
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
