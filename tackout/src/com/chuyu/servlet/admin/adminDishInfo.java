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

@WebServlet("/editDish")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class adminDishInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dishId = Integer.parseInt(req.getParameter("dishId"));
        Dish editDish = DishServer.getDishTail(dishId);
        req.getSession().setAttribute("editDish",editDish );
        req.getRequestDispatcher("/adminPage/admin_dishInfoEdit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String applicationPath = getServletContext().getRealPath("");
        String uploadPath = applicationPath + File.separator + "img";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 表单数据
        int dishId = Integer.parseInt(request.getParameter("dishid"));
        String dishName = request.getParameter("dish_name");
        double dishPrice = Double.parseDouble(request.getParameter("dish_price"));
        String dishDescription = request.getParameter("dish_description");
        String imgPath = null; // 最终使用的图片路径

        try {
            // 获取原始菜品对象（比如从 session 或数据库中获取当前菜品）
            Dish originalDish = (Dish) DishServer.getDishTail(dishId);

            if (originalDish == null) {
                throw new ServletException("原始菜品信息不存在，请重新进入编辑页面。");
            }

            imgPath = "/img/" + originalDish.getImg(); // 默认使用原图路径
            String uuidFileName=null;
            // 遍历所有 part 处理表单数据
            for (Part part : request.getParts()) {
                String partName = part.getName();

                if (part.getSubmittedFileName() == null || part.getSubmittedFileName().isEmpty()) {
                    // 普通字段处理
                    switch (partName) {
                        case "dishid":
                            String idStr = readPartContent(part);
                            if (idStr != null && !idStr.isEmpty()) {
                                dishId = Integer.parseInt(idStr);
                            }
                            break;
                        case "dish_name":
                            dishName = readPartContent(part);
                            break;
                        case "dish_price":
                            String priceStr = readPartContent(part);
                            if (priceStr != null && !priceStr.isEmpty()) {
                                dishPrice = Double.parseDouble(priceStr);
                            }
                            break;
                        case "dish_description":
                            dishDescription = readPartContent(part);
                            break;
                    }
                } else {
                    // 文件上传字段处理
                    String fileName = part.getSubmittedFileName();
                    if (fileName != null && !fileName.isEmpty()) {
                        String fileExtension = "";
                        int dotIndex = fileName.lastIndexOf('.');
                        if (dotIndex > 0) {
                            fileExtension = fileName.substring(dotIndex);
                        }

                        uuidFileName = UUID.randomUUID().toString() + fileExtension;
                        String filePath = "E:\\javaclass\\JavaWeb_School\\tackout\\web\\img\\" + uuidFileName;
                        part.write(filePath);

                        imgPath = "/img/" + uuidFileName; // 替换为新上传的文件路径
                    }
                }
            }

            // 校验必要字段是否完整
            if (dishId == -1 || dishName == null || dishDescription == null) {
                throw new ServletException("缺少必要参数");
            }

            // 构造新的 Dish 对象
            Dish updatedDish = new Dish(dishId, dishName, dishPrice, uuidFileName, dishDescription);

            // 更新数据库（假设你有 DishServer 类）
            boolean success = DishServer.updateDishInfo(updatedDish);

            if (success) {
                // 成功跳转
                response.sendRedirect(request.getContextPath() + "/adminDishEdit");
            } else {
                // 数据库操作失败
                response.sendRedirect(request.getContextPath() + "/editDish");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "处理菜品修改失败: " + e.getMessage());
        }
    }

    // 辅助方法：读取 Part 的内容（用于普通表单字段）
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
