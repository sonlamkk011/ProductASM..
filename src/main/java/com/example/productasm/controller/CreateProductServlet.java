package com.example.productasm.controller;

import com.example.productasm.entity.Product;
import com.example.productasm.model.MySQLProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServlet extends HttpServlet {
    private MySQLProductModel mySQLProductModel;
    @Override
    public void init() throws ServletException {
        mySQLProductModel = new MySQLProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/products/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        Double price = 0.0;
        if(req.getParameter("price") != null && req.getParameter("price") != "") {
            price = Double.parseDouble(req.getParameter("price"));
        }
        String thumbnail = req.getParameter("thumbnail");
        String manufactureEmail = req.getParameter("manufactureEmail");
        String manufacturePhone = req.getParameter("manufacturePhone");
        Product product = new Product(name, description,detail, price,  thumbnail, manufactureEmail, manufacturePhone);
        if(product.isValid()) {
            mySQLProductModel.save(product);
            resp.sendRedirect("/list");
        }else {
            req.setAttribute("errors", product.getErrors());
            req.setAttribute("product", product);
            req.getRequestDispatcher("/products/create.jsp").forward(req,resp);
        }
    }
}

