package com.example.productasm.model.seeder;

import com.example.productasm.model.CategoryModel;
import com.example.productasm.model.MySQLCategoryModel;

public class CategorySeeder {
    private CategoryModel categoryModel;

    public CategorySeeder(){
        this.categoryModel = new MySQLCategoryModel();
    }
    public void seedData(){

    }

}
