package com.example.productasm.entity;

import com.example.productasm.entity.base.BaseEntity;
import com.example.productasm.entity.entityEnum.ProductStatus;

import java.time.LocalDateTime;

public class Product extends BaseEntity {
    private int id;
    private int categoryId;
    private String name;
//    private String slug;
    private String description;
    private String detail;
    private String thumbnail;
    private double price;

    public Product() {

    }
    public Product(int id, int categoryId, String name, String description, String detail, String thumbnail, double price) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.thumbnail = thumbnail;
        this.price = price;
    }

    public Product(int categoryId, String name, String description, String detail, String thumbnail, double price) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.thumbnail = thumbnail;
        this.price = price;
    }

    public Product(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ProductStatus productStatus, int id, int categoryId, String name, String description, String detail, String thumbnail, double price) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, productStatus);
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.thumbnail = thumbnail;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




}
