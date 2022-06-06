package com.example.productasm.controller.product;

import com.example.productasm.entity.Category;
import com.example.productasm.model.CategoryModel;
import com.example.productasm.model.MySQLCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;
    @Override
    public void init() throws ServletException {
        categoryModel = new MySQLCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/Admin/category/list.jsp").forward(req, resp);
    }
}
