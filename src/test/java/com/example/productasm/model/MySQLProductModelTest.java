package com.example.productasm.model;

import com.example.productasm.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySQLProductModelTest {
    private ProductModel productModel;

    @BeforeEach
    void setUp() {
        productModel = new MySQLProductModel();
        Product product = new Product("Product 12", "Demo12", "Detail", 100000, "src/images/product1.png", "demo@gmail.com", "033456789" );
        productModel.save(product);
    }

    @Test
    void save() {
        Product product = new Product("Product 1", "Demo description", "Detail", 100000, "src/images/diep.png", "demo@gmail.com", "033456789" );
        assertEquals(true, productModel.save(product));
    }
}