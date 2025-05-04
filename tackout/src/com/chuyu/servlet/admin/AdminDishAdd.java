package com.chuyu.servlet.admin;

import com.chuyu.bean.Dish;
import com.chuyu.server.DishServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet("/adminDishAdd")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 1024 * 1024 * 10,  // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class AdminDishAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取应用的实际路径
        String applicationPath = getServletContext().getRealPath("");
        // 构建完整的上传路径
        String uploadFilePath = applicationPath + File.separator + "img";

        // 创建上传目录（如果不存在）
        File uploadDir = new File(uploadFilePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 获取表单参数
        String dishName = request.getParameter("dish_name");
        System.out.println(request.getParameter("dish_price"));
        double dishPrice = Double.parseDouble(request.getParameter("dish_price"));
        String dishDescription = request.getParameter("dish_description");

        // 处理文件上传
        String uuidFileName = null;
        for (Part part : request.getParts()) {
            if (part.getName().equals("dish_image")) {
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                if (fileName != null && !fileName.isEmpty()) {
                    String fileExtension = "";
                    int i = fileName.lastIndexOf('.');
                    if (i > 0) {
                        fileExtension = fileName.substring(i);
                    }
                    uuidFileName = UUID.randomUUID().toString() + fileExtension;
                    String filePath = "E:\\javaclass\\JavaWeb_School\\tackout\\web\\img\\" + uuidFileName;
                    part.write(filePath);
                }
            }
        }

        // 如果没有选择图片，则设置默认值或抛出异常
        if (uuidFileName == null) {
            throw new ServletException("请上传菜品图片");
        }

        Dish dish = new Dish(dishName, dishPrice, uuidFileName, dishDescription);

        // 调用服务层方法将数据插入数据库（假设你有 DishServer.addDish 方法）
        boolean addDishFlag = DishServer.addDish(dish);

        if (addDishFlag) {
            // 成功跳转
            response.sendRedirect(request.getContextPath() + "/adminDishEdit");
        } else {
            // 数据库操作失败
            response.sendRedirect(request.getContextPath() + "/adminPage/admin_dishadd.jsp");
        }
    }

    private String readPartContent(Part part) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"))) {
            char[] buffer = new char[1024];
            int len;
            while ((len = reader.read(buffer)) > 0) {
                sb.append(buffer, 0, len);
            }
        }
        return sb.toString();
    }
}
