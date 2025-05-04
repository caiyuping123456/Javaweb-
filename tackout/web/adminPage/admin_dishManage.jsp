<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/29
  Time: 16:12
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
    <title>订单处理</title>
</head>

<body class="bg-gray-100 flex">
<!-- 侧边栏 -->
<aside class="bg-yellow-600 text-white w-64 h-screen p-4">
    <h2 class="text-xl font-bold mb-4">功能菜单</h2>
    <ul class="space-y-2">
        <li><a href="/adminIndex" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">首页</a></li>
        <li><a href="#" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">订单处理</a></li>
        <li><a href="/adminDishEdit" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">菜品管理</a></li>
        <li><a href="/adminUserEdit" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">用户管理</a></li>
        <li><a href="/adminTuichu" class="block py-2 px-4 hover:bg-yellow-700 rounded-md">退出登录</a></li>
    </ul>
</aside>
<!-- 主内容区 -->
<div class="flex-1">
    <header class="bg-yellow-500 text-white p-4">
        <h1 class="text-2xl font-bold">订单处理</h1>
    </header>
    <main class="p-4">
        <h2 class="text-xl font-bold mb-2">订单列表</h2>
        <div class="flex mb-4 space-x-4">
            <input type="text" id="order-search" class="border border-gray-300 rounded-md px-3 py-2" placeholder="按订单号搜索">
            <a>
                <button id="search-button" class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-yellow-600 hover:bg-yellow-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-yellow-500">确定</button>
            </a>
            <a>
                <button class="status-button active bg-yellow-600 text-white px-4 py-2 rounded-md" data-status="全部">全部</button>
            </a>
            <a>
                <button class="status-button bg-yellow-600 text-white px-4 py-2 rounded-md" data-status="待处理">待处理</button>
            </a>
            <a>
                <button class="status-button bg-yellow-600 text-white px-4 py-2 rounded-md" data-status="已接单">已接单</button>
            </a>
            <a>
                <button class="status-button bg-yellow-600 text-white px-4 py-2 rounded-md" data-status="配送中">配送中</button>
            </a>
            <a>
                <button class="status-button bg-yellow-600 text-white px-4 py-2 rounded-md" data-status="已送达">已送达</button>
            </a>
        </div>
        <table id="order-table" class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
            <tr>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">订单编号</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">用户名</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">电话</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">状态</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">操作</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            <tr>
                <td class="px-6 py-4 whitespace-nowrap">1</td>
                <td class="px-6 py-4 whitespace-nowrap">张三</td>
                <td class="px-6 py-4 whitespace-nowrap">13800138000</td>
                <td class="px-6 py-4 whitespace-nowrap">待处理</td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <a href="admin_order.html?order_id=1&status=待处理" class="inline-flex justify-center py-1 px-2 border border-transparent shadow-sm text-xs font-medium rounded-md text-white bg-yellow-600 hover:bg-yellow-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-yellow-500">处理订单</a>
                </td>
            </tr>
            <tr>
                <td class="px-6 py-4 whitespace-nowrap">2</td>
                <td class="px-6 py-4 whitespace-nowrap">李四</td>
                <td class="px-6 py-4 whitespace-nowrap">13900139000</td>
                <td class="px-6 py-4 whitespace-nowrap">已接单</td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <a href="admin_order.html?order_id=2&status=已接单" class="inline-flex justify-center py-1 px-2 border border-transparent shadow-sm text-xs font-medium rounded-md text-white bg-yellow-600 hover:bg-yellow-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-yellow-500">处理订单</a>
                </td>
            </tr>
            <!-- 可添加更多订单 -->
            </tbody>
        </table>
    </main>
</div>
</body>

</html>
