<%--
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
    <title>处理订单</title>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            const urlParams = new URLSearchParams(window.location.search);
            const status = urlParams.get('status');
            const statusElement = document.getElementById('order-status');
            statusElement.textContent = `状态: ${status}`;

            const actionButton = document.getElementById('action-button');

            switch (status) {
                case '待处理':
                    actionButton.textContent = '接单';
                    actionButton.disabled = false;
                    actionButton.classList.remove('bg-blue-600', 'bg-green-600');
                    actionButton.classList.add('bg-yellow-600');
                    break;
                case '已接单':
                    actionButton.textContent = '开始配送';
                    actionButton.disabled = false;
                    actionButton.classList.remove('bg-yellow-600', 'bg-green-600');
                    actionButton.classList.add('bg-blue-600');
                    break;
                case '配送中':
                    actionButton.textContent = '完成订单';
                    actionButton.disabled = false;
                    actionButton.classList.remove('bg-yellow-600', 'bg-blue-600');
                    actionButton.classList.add('bg-green-600');
                    break;
                case '已送达':
                    actionButton.textContent = '订单已完成';
                    actionButton.disabled = true;
                    actionButton.classList.remove('bg-yellow-600', 'bg-blue-600', 'bg-green-600');
                    actionButton.classList.add('bg-gray-600');
                    break;
            }

            actionButton.addEventListener('click', function () {
                let newStatus;
                switch (status) {
                    case '待处理':
                        newStatus = '已接单';
                        break;
                    case '已接单':
                        newStatus = '配送中';
                        break;
                    case '配送中':
                        newStatus = '已送达';
                        break;
                }
                if (newStatus) {
                    // 这里可以添加向后端发送请求的代码
                    window.location.href = `order_processing.html?order_id=1&status=${newStatus}`;
                }
            });
        });
    </script>
</head>

<body class="bg-gray-100 p-4">
<header class="bg-yellow-500 text-white p-4">
    <h1 class="text-2xl font-bold">处理订单</h1>
</header>
<main class="p-4">
    <section class="mb-4">
        <h2 class="text-xl font-bold mb-2">订单详情</h2>
        <div class="bg-white rounded-lg shadow-md p-4">
            <p class="text-lg font-bold mb-2">订单编号: 1</p>
            <p class="mb-2">用户名: 张三</p>
            <p class="mb-2">电话: 13800138000</p>
            <p class="mb-2">地址: 示例地址 123 号</p>
            <h3 class="text-lg font-bold mb-2">菜品信息</h3>
            <ul>
                <li>宫保鸡丁 - ￥25</li>
                <li>鱼香肉丝 - ￥22</li>
            </ul>
            <p class="text-lg font-bold mt-4">总金额: ￥47</p>
            <p class="mb-2">备注：部分菜品有特殊要求</p>
            <p id="order-status" class="mb-2">状态: 待处理</p>
        </div>
    </section>
    <section>
        <h2 class="text-xl font-bold mb-2">操作</h2>
        <div class="flex space-x-4">
            <button id="action-button" class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-yellow-600 hover:bg-yellow-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-yellow-500">接单</button>
            <button class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-red-600 hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-red-500">取消订单</button>
        </div>
    </section>
</main>
</body>

</html>
