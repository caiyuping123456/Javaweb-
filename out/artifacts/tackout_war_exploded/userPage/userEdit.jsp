<%@ page import="com.chuyu.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/29
  Time: 16:05
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
    <title>修改信息</title>
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

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .submit-btn {
            background-color: #ed8936;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .submit-btn:hover {
            background-color: #dd6b20;
        }

        .error-message {
            color: red;
            margin-top: 5px;
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
    <h1>修改信息</h1>
</div>

<!-- 主内容区域 -->
<div class="main-content">
    <%
        User user = (User) request.getSession().getAttribute("user");
    %>
    <form id="modify-info-form" action="/userEdit" method="post">
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" id="username" name="username" placeholder="<%=user.getUserName()%>">
            <div class="error-message" id="username-error"></div>
        </div>
        <div class="form-group">
            <label for="phone">手机号</label>
            <input type="text" id="phone" name="phone" placeholder="<%=user.getPhone()%>">
            <div class="error-message" id="phone-error"></div>
        </div>
        <div class="form-group">
            <%--@declare id="text"--%><label for="text">地址</label>
            <input type="text" id="address" name="address" placeholder="<%=user.getAddress()%>">
            <div class="error-message" id="email-error"></div>
        </div>
        <button type="submit" class="submit-btn">提交修改</button>
    </form>
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