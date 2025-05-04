<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/28
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>外卖系统注册</title>
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

        .registration-container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        .registration-container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .registration-container input[type="text"],
        .registration-container input[type="password"],
        .registration-container input[type="tel"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .registration-container button {
            width: 100%;
            padding: 10px;
            background-color: #ff6600;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .registration-container button:hover {
            background-color: #cc5200;
        }

        .error-message {
            color: red;
            margin-top: 5px;
            text-align: left;
        }
    </style>
</head>

<body>
<div class="registration-container">
    <h2>外卖系统注册</h2>
    <c:if test="${!empty failMsg }">
        <div class="alert alert-danger">${failMsg }</div>
    </c:if>
    <form action="/register" method="post">
        <input type="text" placeholder="姓名" name="name">
        <div class="error-message" id="name-error"></div>
        <input type="tel" placeholder="电话" name="phone">
        <div class="error-message" id="phone-error"></div>
        <input type="text" placeholder="地址" name="address">
        <div class="error-message" id="address-error"></div>
        <input type="password" placeholder="密码" name="password">
        <div class="error-message" id="password-error"></div>
        <button type="submit">注册</button>
    </form>
</div>
<script>
    document.getElementById('registration-form').addEventListener('submit', function (e) {
        e.preventDefault();
        // 清空之前的错误信息
        const errorMessages = document.querySelectorAll('.error-message');
        errorMessages.forEach(function (message) {
            message.textContent = '';
        });
        const name = document.getElementById('name').value;
        const phone = document.getElementById('phone').value;
        const address = document.getElementById('address').value;
        const password = document.getElementById('password').value;
        let hasError = false;
        // 验证姓名
        if (name.trim() === '') {
            document.getElementById('name-error').textContent = '姓名不能为空';
            hasError = true;
        }
        // 验证电话
        if (phone.trim() === '') {
            document.getElementById('phone-error').textContent = '电话不能为空';
            hasError = true;
        } else if (!/^1[3-9]\d{9}$/.test(phone)) {
            document.getElementById('phone-error').textContent = '请输入有效的手机号码';
            hasError = true;
        }

        // 验证地址
        if (address.trim() === '') {
            document.getElementById('address-error').textContent = '地址不能为空';
            hasError = true;
        }

        // 验证密码
        if (password.trim() === '') {
            document.getElementById('password-error').textContent = '密码不能为空';
            hasError = true;
        }
    });
</script>
</body>
</html>