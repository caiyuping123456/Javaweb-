<%@ page import="com.chuyu.bean.Dish" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/29
  Time: 16:11
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
    <title>菜品管理</title>
    <style>
        /* 增加搜索框长度 */
        .search-input {
            width: 70%;
        }
        /* 增加搜索框和下方内容的间距 */
        .search-form {
            margin-bottom: 2rem;
        }

    </style>
</head>

<body class="bg-gray-100">
<!-- 侧边栏 -->
<aside class="bg-yellow-600 text-white w-64 h-screen p-4 fixed top-0 left-0">
    <h2 class="text-xl font-bold mb-4">功能菜单</h2>
    <ul class="space-y-2">
        <li><a href="/adminIndex" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">首页</a></li>
        <li><a href="/adminDishManage" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">订单处理</a></li>
        <li><a href="#" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">菜品管理</a></li>
        <li><a href="/adminUserEdit" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">用户管理</a></li>
        <li><a href="/adminTuichu" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">退出登录</a></li>
    </ul>
</aside>
<!-- 主内容区 -->
<div class="ml-64 p-4">
    <header class="bg-yellow-500 text-white p-4">
        <h1 class="text-2xl font-bold">菜品管理</h1>
    </header>
    <main class="p-4">
        <!-- 搜索框 -->
        <div class="flex mb-4 search-form">
            <form action="/adminDishEdit" method="post">
                <input type="text" name="dish_name" class="border border-gray-300 rounded-md px-3 py-2 mr-2 search-input" placeholder="按菜品名字搜索">
                <input type="submit" class="bg-yellow-600 text-white px-4 py-2 rounded-md hover:bg-yellow-700" value="查找">
            </form>
            <a href="/adminPage/admin_dishadd.jsp" class="bg-yellow-600 text-white px-4 py-2 rounded-md hover:bg-yellow-700 mb-4 add-dish-button">添加菜品</a>
        </div>
        <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
            <tr>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">菜品名称</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">价格</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">描述</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">操作</th>
            </tr>
            </thead>
            <tbody id="dish-list" class="bg-white divide-y divide-gray-200">
            <%
                List<Dish> dishList = (List<Dish>)request.getSession().getAttribute("dishList");
                for(Dish dish : dishList){
            %>
                <tr>
                    <td class="px-6 py-4 whitespace-nowrap"><%=dish.getDishid()%></td>
                    <td class="px-6 py-4 whitespace-nowrap"><%=dish.getDishname()%></td>
                    <td class="px-6 py-4 whitespace-nowrap"><%=dish.getPrice()!=0.0?dish.getPrice():"该菜品暂未定价"%>￥</td>
                    <td class="px-6 py-4 whitespace-nowrap"><%=dish.getDescribes()!=null?dish.getDescribes():"该菜品暂无简介"%></td>
                    <td class="px-6 py-4 whitespace-nowrap">
                        <a href="/editDish?dishId=<%=dish.getDishid()%>" class="bg-yellow-600 text-white px-2 py-1 rounded-md hover:bg-yellow-700 mr-2">编辑</a>
                        <a href="/delsteDish?dishId=<%=dish.getDishid()%>" class="bg-red-600 text-white px-2 py-1 rounded-md hover:bg-red-700">删除</a>
                    </td>
                </tr>
            <%
                }
                request.getSession().removeAttribute("dishList");
            %>
            </tbody>
        </table>
    </main>
</div>
</body>

</html>

