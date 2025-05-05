<%--
  Created by IntelliJ IDEA.
  User: cai
  Date: 2025/4/29
  Time: 16:15
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
    <title>添加菜品</title>
    <style>
        body {
            font-family: 'Inter', sans-serif;
            background-color: #f3f4f6;
        }

        .main-content {
            padding: 2rem;
        }

        .main-content header {
            background-color: #ffc107;
            color: white;
            padding: 1rem;
            border-radius: 0.25rem;
            margin-bottom: 2rem;
        }

        .main-content h1 {
            font-size: 1.5rem;
            font-weight: 600;
        }

        .form-group {
            margin-bottom: 1rem;
        }

        .form-group label {
            display: block;
            font-size: 0.875rem;
            font-weight: 500;
            margin-bottom: 0.25rem;
        }

        .form-group input,
        .form-group textarea,
        .form-group input[type="file"] {
            width: 100%;
            padding: 0.5rem;
            border: 1px solid #ccc;
            border-radius: 0.25rem;
            outline: none;
            transition: border-color 0.3s ease;
        }

        .form-group input:focus,
        .form-group textarea:focus,
        .form-group input[type="file"]:focus {
            border-color: #ffc107;
            box-shadow: 0 0 0 3px rgba(255, 193, 7, 0.25);
        }

        .btn {
            background-color: #ffc107;
            color: white;
            padding: 0.5rem 1rem;
            border: none;
            border-radius: 0.25rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #e0a800;
        }

        .dish-image-preview {
            margin-top: 0.5rem;
            max-width: 200px;
            max-height: 200px;
            border: 1px solid #ccc;
            border-radius: 0.25rem;
        }
    </style>
</head>

<body>
<!-- 主内容区 -->
<div class="main-content">
    <header>
        <h1>添加菜品</h1>
    </header>
    <main>
        <form action="/adminDishAdd" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="dish-name">菜品名称</label>
                <input type="text" id="dish-name" name="dish_name" placeholder="请输入菜品名称">
            </div>
            <div class="form-group">
                <label for="dish-price">价格</label>
                <input type="text" id="dish-price" name="dish_price" placeholder="请输入菜品价格">
            </div>
            <div class="form-group">
                <label for="dish-description">描述</label>
                <textarea id="dish-description" name="dish_description" placeholder="请输入菜品描述"></textarea>
            </div>
            <div class="form-group">
                <label for="dish-image">菜品图片</label>
                <input type="file" id="dish-image" name="dish_image">
            </div>
            <button type="submit" class="btn">添加菜品</button>
        </form>
    </main>
</div>
</body>

</html>

