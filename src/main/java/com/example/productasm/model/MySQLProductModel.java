package com.example.productasm.model;

import com.example.productasm.contans.SQLcontants;
import com.example.productasm.entity.Product;
import com.example.productasm.entity.entityEnum.ProductStatus;
import com.example.productasm.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLProductModel implements ProductModel {


    public MySQLProductModel() {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean save(Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLcontants.PRODUCT_INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getDetail());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getThumbnail());
            preparedStatement.setString(6, product.getCreatedAt().toString());
            preparedStatement.setString(7, product.getUpdatedAt().toString());
            if (product.getDeletedAt() != null) {
                preparedStatement.setString(8, product.getDeletedAt().toString());
            } else {
                preparedStatement.setString(8, null);
            }
            preparedStatement.setInt(9, product.getCreatedBy());
            preparedStatement.setInt(10, product.getUpdatedBy());
            preparedStatement.setInt(11, product.getDeletedBy());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLcontants.PRODUCT_UPDATE);
            preparedStatement.setInt(1 , product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getDetail());
            preparedStatement.setDouble(5, product.getPrice());
            preparedStatement.setString(6, product.getThumbnail());
            preparedStatement.setString(7, product.getCreatedAt().toString());
            preparedStatement.setString(8, product.getUpdatedAt().toString());
            if (product.getDeletedAt() != null) {
                preparedStatement.setString(9, product.getDeletedAt().toString());
            } else {
                preparedStatement.setString(9, null);
            }
            preparedStatement.setInt(10, product.getCreatedBy());
            preparedStatement.setInt(11, product.getUpdatedBy());
            preparedStatement.setInt(12, product.getDeletedBy());
            preparedStatement.setInt(13, product.getProductStatus().getValue());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
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
            Connection connection = ConnectionHelper.getConnection();
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

