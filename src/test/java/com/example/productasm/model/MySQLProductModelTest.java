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
        Product product = new Product(1, 1, "diep", "122", "src/images/product1.png", "demo@gmail.com", 111 );
        productModel.save(product);
    }

    @Test
    void save() {
        Product product = new Product(1, 1, "diep1", "122", "src/images/product1.png", "demo@gmail.com", 111 );
        assertEquals(true, productModel.save(product));
    }


}