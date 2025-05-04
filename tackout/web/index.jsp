<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/28
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>外卖系统登录</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-image: url('https://img.alicdn.com/imgextra/i4/O1CN01qyQpLl25eXZvH4PzG_!!6000000007765-2-tps-1920-1080.jpg');
      background-size: cover;
      background-position: center;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .login-container {
      background-color: rgba(255, 255, 255, 0.8);
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 300px;
      text-align: center;
    }

    .login-container h2 {
      margin-bottom: 20px;
      color: #333;
    }

    .login-container input[type="text"],
    .login-container input[type="password"] {
      width: calc(100% - 22px);
      padding: 10px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .login-container button {
      width: 100%;
      padding: 10px;
      background-color: #ff6600;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    .login-container button:hover {
      background-color: #cc5200;
    }

    .switch-btn {
      background: none;
      border: none;
      color: #ff6600;
      text-decoration: underline;
      cursor: pointer;
      margin-top: 10px;
    }
    .register-form {
      display: none;
    }
  </style>
</head>
<body>
<div class="login-container">
  <h2>外卖系统登录</h2>
    <c:if test="${!empty msg }">
        <div class="alert alert-success">${msg }</div>
    </c:if>
  <div class="login-form">
        <form action="/index" method="post">
            <input type="text" placeholder="用户名" name="username">
            <input type="password" placeholder="密码" name="password">
            <button type="submit">登录</button>
        </form>
        <a href="register.jsp">
            <button class="switch-btn">没有账号？注册</button>
        </a>

  </div>
</div>
</body>
</html>