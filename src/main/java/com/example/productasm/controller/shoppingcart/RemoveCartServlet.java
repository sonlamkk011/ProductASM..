package com.example.productasm.controller.shoppingcart;

import com.example.productasm.entity.Product;
import com.example.productasm.entity.ShoppingCart;
import com.example.productasm.model.MySQLProductModel;
import com.example.productasm.model.ProductModel;
import com.example.productasm.util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveCartServlet extends HttpServlet {
    private ProductModel productModel;

    public RemoveCartServlet() {
        this.productModel = new MySQLProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            Product product = productModel.findById(productId);

            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
            ShoppingCart shoppingCart = shoppingCartHelper.getCart();
            shoppingCart.remove(productId);
            shoppingCartHelper.saveCart(shoppingCart);
            resp.sendRedirect("/client/list");

        } catch (Exception ex) {
            resp.getWriter().println(ex.getMessage());
        }

    }
}
