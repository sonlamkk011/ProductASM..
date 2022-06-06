package com.example.productasm.model;

import com.example.productasm.contans.SQLcontants;
import com.example.productasm.entity.Category;
import com.example.productasm.entity.entityEnum.CategoryStatus;
import com.example.productasm.util.ConnectionHelper;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoryModel implements CategoryModel{

    @Override
    public boolean save(Category obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(SQLcontants.CATEGORY_INSERT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getCreatedAt().toString());
            preparedStatement.setString(3, obj.getUpdatedAt().toString());
            preparedStatement.setInt(4, obj.getCreatedBy());
            preparedStatement.setInt(5, obj.getUpdatedBy());
//            preparedStatement.setInt(6, obj.getStatus().getValue());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Category updateObj) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQLcontants.CATEGORY_UPDATE);
            preparedStatement.setString(1, updateObj.getName());
            preparedStatement.setString(2, updateObj.getUpdatedAt().toString());
            preparedStatement.setInt(3, updateObj.getUpdatedBy());
//            preparedStatement.setInt(4, updateObj.getStatus().getValue());
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQLcontants.CATEGORY_DELETE);
            preparedStatement.setInt(1, CategoryStatus.DELETED.getValue());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> findAll() {
        List<Category> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQLcontants.CATEGORY_SELECT_ALL);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category obj = convertResultSetToCategory(resultSet);
                if (obj != null) {
                    listObj.add(obj);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listObj;
    }

    @Override
    public Category findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQLcontants.CATEGORY_SELECT_BY_ID);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return convertResultSetToCategory(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Category convertResultSetToCategory(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(SQLcontants.CATEGORY_FIELD_ID);
            String name = resultSet.getString(SQLcontants.CATEGORY_FIELD_NAME);
            int status = resultSet.getInt(SQLcontants.CATEGORY_FIELD_STATUS);
            LocalDateTime createdAt = resultSet.getTimestamp(SQLcontants.FIELD_CREATED_AT).toLocalDateTime();
            LocalDateTime updatedAt = resultSet.getTimestamp(SQLcontants.FIELD_UPDATED_AT).toLocalDateTime();
            LocalDateTime deletedAt = null;
            Timestamp timestamp = resultSet.getTimestamp(SQLcontants.FIELD_DELETED_AT);
            if (timestamp != null) {
                deletedAt = timestamp.toLocalDateTime();
            }
            int createdBy = resultSet.getInt(SQLcontants.FIELD_CREATED_BY);
            int updatedBy = resultSet.getInt(SQLcontants.FIELD_UPDATED_BY);
            int deletedBy = resultSet.getInt(SQLcontants.FIELD_DELETED_BY);

        } catch (SQLException ex) {
        }
        return null;
    }
}
