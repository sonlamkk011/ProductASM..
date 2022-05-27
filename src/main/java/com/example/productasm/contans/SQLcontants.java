package com.example.productasm.contans;

public class SQLcontants {
        public  static final String PRODUCT_INSERT = " INSERT INTO products ( name, description, detail, price, thumbnail, manufactureEmail, manufacturePhone," + " createAt, updateAt, deleteAt, createBy, updateBy, deleteBy, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        public static final String PRODUCT_UPDATE = " UPDATE product SET name = ?, description = ?, detail = ?, price = ?, thumbnail = ?, manufactureEmail = ?, manufacturePhone = ?," + " createAt = ?, updateAt = ?, deleteAt = ?, createBy = ?, updateBy = ?, deleteBy = ?, status = ? WHERE id = ?;";
        public static final String PRODUCT_DELETE = "DELETE FROM products WHERE id = ?;";
        public static final String PRODUCT_FIND_BY_ID = " SELECT * FROM products WHERE id = ? AND status = ?;";
        public static final String PRODUCT_FIND_ALL = "SELECT * FROM products WHERE status = ?;";
}
