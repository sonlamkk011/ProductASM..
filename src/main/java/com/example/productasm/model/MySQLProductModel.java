package com.example.productasm.model;

import com.example.productasm.contans.SQLcontants;
import com.example.productasm.entity.Product;
import com.example.productasm.entity.entityEnum.ProductStatus;
import com.example.productasm.util.ConnectionHepler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLProductModel implements ProductModel {


    public MySQLProductModel() {

    }

    @Override
    public boolean save (Product product) {
        try {
            Connection connection = ConnectionHepler.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLcontants.PRODUCT_INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getDetail());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getThumbnail());
            preparedStatement.setString(6, product.getManufactureEmail());
            preparedStatement.setString(7, product.getManufacturePhone());
            preparedStatement.setString(8, product.getCreatedAt().toString());
            preparedStatement.setString(9, product.getUpdatedAt().toString());
            if (product.getDeletedAt() != null) {
                preparedStatement.setString(10, product.getDeletedAt().toString());
            } else {
                preparedStatement.setString(10, null);
            }
            preparedStatement.setInt(11, product.getCreatedBy());
            preparedStatement.setInt(12, product.getUpdatedBy());
            preparedStatement.setInt(13, product.getDeletedBy());
            preparedStatement.setInt(14, product.getProductStatus().getValue());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        try {
            Connection connection = ConnectionHepler.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLcontants.PRODUCT_UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getDetail());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getThumbnail());
            preparedStatement.setString(6, product.getManufactureEmail());
            preparedStatement.setString(7, product.getManufacturePhone());
            preparedStatement.setString(8, product.getCreatedAt().toString());
            preparedStatement.setString(9, product.getUpdatedAt().toString());
            if (product.getDeletedAt() != null) {
                preparedStatement.setString(10, product.getDeletedAt().toString());
            } else {
                preparedStatement.setString(10, null);
            }
            preparedStatement.setInt(11, product.getCreatedBy());
            preparedStatement.setInt(12, product.getUpdatedBy());
            preparedStatement.setInt(13, product.getDeletedBy());
            preparedStatement.setInt(14, product.getProductStatus().getValue());
            preparedStatement.setInt(15, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHepler.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLcontants.PRODUCT_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        try {
            Connection connection = ConnectionHepler.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLcontants.PRODUCT_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, ProductStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
//                return resultSetToProduct(rs);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}

