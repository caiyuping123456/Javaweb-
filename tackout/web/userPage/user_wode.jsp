<%@ page import="com.chuyu.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/28
  Time: 21:47
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
    <title>外卖用户端 - 我的页面</title>
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
            padding-bottom: 80px;
        }

        .info-section {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }

        .info-section p {
            margin: 5px 0;
        }

        .function-item {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            display: flex;
            align-items: center;
        }

        .function-item:hover {
            background-color: #f0f0f0;
        }

        .function-item i {
            margin-right: 10px;
        }

        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            border-radius: 8px;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
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
    <h1>外卖用户端 - 我的页面</h1>
</div>

<!-- 主内容区域 -->
<div class="main-content">
    <%
        User user = (User)request.getSession().getAttribute("user");
    %>
    <!-- 用户信息部分 -->
    <div class="info-section">
        <p>用户名: <span id="username"><%=user.getUserName()%></span></p>
        <p>手机号: <span id="phone"><%=user.getPhone()%></span></p>
        <p>地址: <span id="email"><%=user.getAddress()%></span></p>
    </div>

    <!-- 功能项部分 -->
    <div class="function-item" onclick="openModifyInfoModal()">
        <i class="fa-solid fa-pen-to-square"></i>
        <a href="/userEdit">
            <span>修改信息</span>
        </a>

    </div>
    <div class="function-item" onclick="openModifyPasswordModal()">
        <i class="fa-solid fa-key"></i>
        <a href="/userPassword">
            <span>修改密码</span>
        </a>

    </div>
    <div class="function-item" onclick="openOrderModal()">
        <i class="fa-solid fa-list"></i>
        <a href="/userDishlist">
            <span>查看订单</span>
        </a>
    </div>
    <div class="function-item">
        <i class="fa-solid fa-right-from-bracket"></i>
        <a href="/userTuichu">
            <span>退出登录</span>
        </a>
    </div>
</div>
<!-- 底部导航栏 -->
<nav class="bottom-nav">
    <a href="/userIndex" class="bottom-nav-item" id="home-btn">
        <i class="fa-solid fa-house"></i>
        <span>首页</span>
    </a>
    <a href="/userCart" class="bottom-nav-item" id="cart-btn">
        <i class="fa-solid fa-cart-shopping"></i>
        <span>购物车</span>
    </a>
    <a href="#" class="bottom-nav-item active" id="profile-btn">
        <i class="fa-solid fa-user"></i>
        <span>我的</span>
    </a>
</nav>
</body>

</html>
