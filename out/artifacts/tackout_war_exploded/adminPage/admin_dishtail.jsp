<%@ page import="com.chuyu.bean.Dish" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 假设通过某种方式（如请求参数）获取了当前要查看的菜品对象
    Dish dish = (Dish) request.getSession().getAttribute("dish");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" rel="stylesheet">
    <title><%=dish.getDishname()%> - 外卖管理端</title>
    <style>
        /* 自定义样式以强调黄色主题 */
        .yellow-theme-text {
            @apply text-yellow-600;
        }
        .yellow-theme-button {
            @apply bg-yellow-400 text-white hover:bg-yellow-500;
        }
    </style>
</head>

<body class="bg-white flex">
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
        <section class="mb-4 bg-white rounded-lg shadow-md p-6 max-w-2xl mx-auto">
            <a href="/adminIndex" class="block mb-4 yellow-theme-text hover:underline">返回列表</a>
            <div class="grid grid-cols-1 gap-4">
                <img src="/img/<%=dish.getImg()%>" alt="<%=dish.getDishname()%> 图片" class="w-full h-40 object-cover rounded-md mb-1"> <!-- 增加了mb-6类以增加底部外边距 -->
                <p><p><h2 class="text-2xl font-bold mb-2 yellow-theme-text"><%=dish.getDishname()%></h2>
                <p class="text-xl font-bold text-yellow-600 mb-2">￥<%=dish.getPrice()%></p>
                <div class="mb-4">
                    <strong class="yellow-theme-text">简介：</strong>
                    <span class="yellow-theme-text"><%=dish.getDescribes() != null ? dish.getDescribes() : "暂无描述"%></span> <!-- 注意：这里假设getDescription是正确的getter方法，原代码中使用了getDescribes，请根据实际类定义调整 -->
                </div>
            </div>
            <%
                request.getSession().removeAttribute("dish");
            %>
        </section>
    </main>
</div>
</body>

</html>