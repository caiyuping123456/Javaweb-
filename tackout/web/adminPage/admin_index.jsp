<%@ page import="com.chuyu.bean.Dish" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/28
  Time: 21:42
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
    <title>外卖管理端</title>
</head>

<body class="bg-gray-100 flex">
<!-- 侧边栏 -->
<aside class="bg-yellow-600 text-white w-64 h-screen p-4">
    <h2 class="text-xl font-bold mb-4">功能菜单</h2>
    <ul class="space-y-2">
        <li><a href="#" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">首页</a></li>
        <li><a href="/adminDishManage" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">订单处理</a></li>
        <li><a href="/adminDishEdit" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">菜品管理</a></li>
        <li><a href="/adminUserEdit" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">用户管理</a></li>
        <li><a href="/adminTuichu" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">退出登录</a></li>
    </ul>
</aside>
<!-- 主内容区 -->
<div class="flex-1">
    <header class="bg-yellow-500 text-white p-4">
        <h1 class="text-2xl font-bold">外卖管理端</h1>
    </header>
    <main class="p-4">
        <section class="mb-4">
            <h2 class="text-xl font-bold mb-2">首页 - 所有菜品</h2>
            <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
            <%
                List<Dish> list = (List<Dish>)request.getSession().getAttribute("dishList");
                for(Dish dish : list){

            %>

                    <a href="/adminDishTail?dishId=<%=dish.getDishid()%>" class="bg-white rounded-lg shadow-md p-4">
                        <img src="/img/<%=dish.getImg()%>" alt="菜品图片" class="w-full h-40 object-cover rounded-md mb-2">
                        <h3 class="text-lg font-bold mb-1"><%=dish.getDishname()%></h3>
                        <p class="text-xl font-bold text-yellow-600">￥<%=dish.getPrice()%></p>
                    </a>

            <%
                }
            %>
        </div>
        </section>
    </main>
</div>
</body>

</html>
