package com.example.productasm.model;

import com.example.productasm.entity.Product;

import java.util.List;

public interface ProductModel {

    boolean save(Product products);

    boolean update(int id, Product products);

    boolean delete(int id);

    List<Product> findAll();

    Product findById(int id);





}