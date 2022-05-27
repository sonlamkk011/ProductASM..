package com.example.productasm.controller;

import com.example.productasm.entity.Product;
import com.example.productasm.model.MySQLProductModel;
import com.example.productasm.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProductServlet extends HttpServlet {
    private ProductModel productModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySQLProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = productModel.findById(Integer.parseInt(req.getParameter("id")));
        if(product == null) {
            product = new Product();
        }
        req.setAttribute("product", product);
        req.getRequestDispatcher("/products/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String thumbnail = req.getParameter("thumbnail");
        Double price = 0.0;
        if(req.getParameter("price") != "" && req.getParameter("price") != null) {
            price = Double.parseDouble(req.getParameter("price"));
        }
        String manufactureEmail = req.getParameter("manufactureEmail");
        String manufacturePhone = req.getParameter("manufacturePhone");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        Product product = new Product(id, name, description, detail, price, thumbnail, manufactureEmail, manufacturePhone);

    }
}
