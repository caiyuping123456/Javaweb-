<%--
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
    <title>添加用户</title>
</head>

<body class="bg-gray-100 flex justify-center items-center h-screen">
<div class="bg-white p-8 rounded-lg shadow-md w-full max-w-md">
    <h2 class="text-2xl font-bold mb-4">添加用户</h2>
    <form id="add-user-form" action="123.html" method="post">
        <div class="mb-4">
            <label name="name" class="block text-sm font-medium text-gray-700">姓名</label>
            <input type="text" name="name" class="mt-1 block w-full border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:ring-yellow-500 focus:border-yellow-500">
        </div>
        <div class="mb-4">
            <label name="phone" class="block text-sm font-medium text-gray-700">电话</label>
            <input type="text" name="phone" class="mt-1 block w-full border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:ring-yellow-500 focus:border-yellow-500">
        </div>
        <div class="mb-4">
            <label name="address" class="block text-sm font-medium text-gray-700">地址</label>
            <input type="text" name="address" class="mt-1 block w-full border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:ring-yellow-500 focus:border-yellow-500">
        </div>
        <div class="flex justify-between items-center">
            <button type="submit" class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-yellow-600 hover:bg-yellow-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-yellow-500">提交</button>
        </div>
        <p id="error-message" class="text-red-500 mt-2"></p>
    </form>
</div>
</body>

</html>

