<%@ page import="com.chuyu.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/29
  Time: 16:16
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
    <title>用户信息</title>
</head>

<body class="bg-gray-100 flex justify-center items-center h-screen">
<div class="bg-white p-8 rounded-lg shadow-md w-full max-w-md">
    <h2 class="text-2xl font-bold mb-4">用户信息</h2>
    <form id="add-user-form">
        <%
            User userInfo = (User) request.getSession().getAttribute("userInfo");
        %>
        <div class="mb-4">
            <label name="name" class="block text-sm font-medium text-gray-700">编号</label>
            <input type="text" readonly name="name" value="<%=userInfo.getId()%>" class="mt-1 block w-full border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:ring-yellow-500 focus:border-yellow-500">
        </div>
        <div class="mb-4">
            <label name="name" class="block text-sm font-medium text-gray-700">姓名</label>
            <input type="text" readonly name="name" value="<%=userInfo.getUserName()%>" class="mt-1 block w-full border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:ring-yellow-500 focus:border-yellow-500">
        </div>
        <div class="mb-4">
            <label name="phone" class="block text-sm font-medium text-gray-700">电话</label>
            <input type="text" readonly name="phone" value="<%=userInfo.getPhone()%>" class="mt-1 block w-full border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:ring-yellow-500 focus:border-yellow-500">
        </div>
        <div class="mb-4">
            <label name="address" class="block text-sm font-medium text-gray-700">地址</label>
            <input type="text" readonly name="address" value="<%=userInfo.getAddress()%>" class="mt-1 block w-full border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:ring-yellow-500 focus:border-yellow-500">
        </div>
        <p id="error-message" class="text-red-500 mt-2"></p>
        <%
            request.getSession().removeAttribute("userInfo");
        %>
    </form>
    <div class="mt-6">
        <button type="button" onclick="window.history.back()" class="w-full bg-yellow-500 text-white py-2 px-4 rounded-md hover:bg-yellow-600 transition duration-200">
            返回
        </button>
    </div>
</div>
</body>

</html>

