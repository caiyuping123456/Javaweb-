<%@ page import="com.chuyu.bean.Dish" %>
<%@ page import="java.util.List" %>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/28
  Time: 21:46
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
    <title>外卖用户端</title>
    <style>
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

<body class="bg-gray-100">
<header class="bg-yellow-500 text-white p-4">
    <h1 class="text-2xl font-bold">外卖用户端</h1>
</header>
<main class="p-4 mb-16">
    <section class="mb-4">
        <h2 class="text-xl font-bold mb-2">菜品列表</h2>
        <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
            <%
                List<Dish> dishList = (List<Dish>) request.getSession().getAttribute("dishList");
                if (dishList != null) {
                    for (Dish dish : dishList) {
            %>
            <div class="bg-white rounded-lg shadow-md p-4">
                <img src="/img/<%= dish.getImg() %>" alt="<%= dish.getDishname() %>" class="w-full h-40 object-cover rounded-md mb-2">
                <h3 class="text-lg font-bold mb-1"><%= dish.getDishname() %></h3>
                <p class="text-gray-600 mb-2"><%= dish.getDescribes() %></p>
                <p class="text-xl font-bold text-yellow-600">￥<%= dish.getPrice() %></p>
                <form action="/userCart" method="post">
                    <input type="hidden" name="dishid" value="<%=dish.getDishid()%>">
                    <input type="submit" name="加入购物车" value="加入购物车" class="mt-2 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-yellow-600 hover:bg-yellow-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-yellow-500">
                </form>
            </div>
            <%
                    }
                }
            %>
        </div>
    </section>
</main>
<nav class="bottom-nav">
    <a href="#" class="bottom-nav-item active" id="home-btn">
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
