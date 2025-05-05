<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/29
  Time: 15:59
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
    <title>修改密码</title>
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
        .error-message {
            color: red;
            font-size: 0.9em;
            margin-top: 5px;
        }
    </style>
    <script type="text/javascript">
        // 页面加载时执行的JavaScript
        window.onload = function() {
            <%
                Boolean modifySuccess = (Boolean) request.getAttribute("modifySuccess");
                if (modifySuccess != null) {
                    if (!modifySuccess) {
                        out.print("alert('密码修改失败，请重试！');");
                    } else {
                        out.print("alert('密码修改成功！');");
                    }
                }
                request.removeAttribute("modifySuccess");
            %>
        };
    </script>
</head>

<body>
<!-- 顶部导航栏 -->
<div class="top-nav">
    <h1>修改密码</h1>
</div>

<!-- 主内容区域 -->
<div class="main-content">
    <form id="modify-password-form" action="/userPassword" method="post">
        <div class="form-group">
            <label for="old-password">旧密码</label>
            <input type="password" id="old-password" name="oldPassword" placeholder="请输入旧密码">
            <div class="error-message" id="old-password-error"></div>
        </div>
        <div class="form-group">
            <label for="new-password">新密码</label>
            <input type="password" id="new-password" name="newPassword" placeholder="请输入新密码">
            <div class="error-message" id="new-password-error"></div>
        </div>
        <div class="form-group">
            <label for="confirm-password">确认新密码</label>
            <input type="password" id="confirm-password" name="confirmPassword" placeholder="请再次输入新密码">
            <div class="error-message" id="confirm-password-error"></div>
        </div>
        <button type="submit" class="submit-btn">提交修改</button>
    </form>
</div>
<script>
    document.getElementById("modify-password-form").addEventListener("submit", function(event) {
        // 获取输入框的值
        const newPassword = document.getElementById("new-password").value.trim();
        const confirmPassword = document.getElementById("confirm-password").value.trim();
        const errorMsg = document.getElementById("confirm-password-error");

        // 清除之前的错误信息
        errorMsg.textContent = "";

        // 判断两次输入的新密码是否一致
        if (newPassword !== confirmPassword) {
            errorMsg.textContent = "两次输入的密码不一致，请重新输入！";
            event.preventDefault(); // 阻止表单提交
            alert("两次输入的新密码不一致，请重新输入！");
        }
    });
</script>
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