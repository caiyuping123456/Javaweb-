<%@ page import="java.util.List" %>
<%@ page import="com.chuyu.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/29
  Time: 16:14
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
    <title>用户管理</title>
</head>

<body class="bg-gray-100 flex">
<!-- 侧边栏 -->
<aside class="bg-yellow-600 text-white w-64 h-screen p-4">
    <h2 class="text-xl font-bold mb-4">功能菜单</h2>
    <ul class="space-y-2">
        <li><a href="/adminIndex" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">首页</a></li>
        <li><a href="/adminDishManage" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">订单处理</a></li>
        <li><a href="/adminDishEdit" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">菜品管理</a></li>
        <li><a href="#" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">用户管理</a></li>
        <li><a href="/adminTuichu" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">退出登录</a></li>
    </ul>
</aside>
<!-- 主内容区 -->
<div class="flex-1">
    <header class="bg-yellow-500 text-white p-4">
        <h1 class="text-2xl font-bold">用户管理</h1>
    </header>
    <main class="p-4">
        <h2 class="text-xl font-bold mb-2">用户列表</h2>
        <div class="flex mb-4 space-x-4">
            <form action="/adminUserEdit" method="post">
                <input type="text" name="dish_name" class="border border-gray-300 rounded-md px-3 py-2 mr-2 search-input" placeholder="按用户名搜索">
                <input type="submit" class="bg-yellow-600 text-white px-4 py-2 rounded-md hover:bg-yellow-700" value="查找">
            </form>
        </div>
        <table id="user-table" class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
            <tr>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">用户ID</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">用户名</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">电话</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">操作</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            <%
                List<User> userList = (List<User>) request.getSession().getAttribute("userList");
                if(userList==null||userList.size()==0){
            %>
                <tr>
                    <td colspan="4" class="px-6 py-4 text-center text-gray-500">暂无用户</td>
                </tr>
            <%
                }
                for(User user: userList){
                    %>
                        <tr>
                            <td class="px-6 py-4 whitespace-nowrap"><%=user.getId()%></td>
                            <td class="px-6 py-4 whitespace-nowrap"><%=user.getUserName()%></td>
                            <td class="px-6 py-4 whitespace-nowrap"><%=user.getPhone()%></td>
                            <td class="px-6 py-4 whitespace-nowrap">
                                <a href="/adminUserInfo?userId=<%=user.getId()%>">
                                    <button class="view-user-info-button inline-flex justify-center py-1 px-2 border border-transparent shadow-sm text-xs font-medium rounded-md text-white bg-yellow-600 hover:bg-yellow-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-yellow-500">查看用户信息</button>
                                </a>
                                <a href="/adminUserDelete?userId=<%=user.getId()%>">
                                    <button class="delete-user-button inline-flex justify-center py-1 px-2 border border-transparent shadow-sm text-xs font-medium rounded-md text-white bg-red-600 hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-red-500">删除</button>
                                </a>
                            </td>
                        </tr>
                    <%
                }
                request.getSession().removeAttribute("userList");
            %>
            </tbody>
        </table>
    </main>
</div>
</body>

</html>
