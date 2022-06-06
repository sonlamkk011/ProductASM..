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

public class SubCartServlet extends HttpServlet {
    private ProductModel productModel;

    public SubCartServlet() {
        this.productModel = new MySQLProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            Integer quantity = Integer.parseInt(req.getParameter("quantity"));
            Product product = productModel.findById(productId);
            if (product == null) {
                resp.getWriter().println("product is not found");
                return;
            }
            if (quantity <= 0) {
                resp.getWriter().println("Invalid");
                return;
            }
            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
            ShoppingCart shoppingCart = shoppingCartHelper.getCart();
            shoppingCart.sub(product, quantity);
            shoppingCartHelper.saveCart(shoppingCart);
            resp.sendRedirect("/shopping/getcart");

        } catch (Exception ex) {
            resp.getWriter().println(ex.getMessage());
        }

    }
}
