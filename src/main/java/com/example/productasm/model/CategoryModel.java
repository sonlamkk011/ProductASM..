package com.example.productasm.model;

import com.example.productasm.entity.Category;

import java.util.List;

public interface CategoryModel {
    boolean save(Category obj);
    boolean update (int id, Category updateObj);
    boolean delete(int id);
    List<Category> findAll();
    Category findById(int id);
}
