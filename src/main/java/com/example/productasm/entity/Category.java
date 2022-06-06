package com.example.productasm.entity;

import com.example.productasm.entity.base.BaseEntity;
import com.example.productasm.entity.entityEnum.CategoryStatus;
import com.example.productasm.entity.entityEnum.ProductStatus;

import java.time.LocalDateTime;

public class Category extends BaseEntity {
    private int id;
    private String name;


    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(int id, String name, CategoryStatus status, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ProductStatus productStatus) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, productStatus);
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
