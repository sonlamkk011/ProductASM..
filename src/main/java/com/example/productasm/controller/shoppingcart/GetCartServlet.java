package com.example.productasm.controller.shoppingcart;

import com.example.productasm.entity.ShoppingCart;
import com.example.productasm.util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/client/view.jsp").forward(req, resp);




    }
}
