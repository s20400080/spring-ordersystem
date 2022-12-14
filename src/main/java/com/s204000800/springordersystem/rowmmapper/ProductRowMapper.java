package com.s204000800.springordersystem.rowmmapper;

import com.s204000800.springordersystem.constant.ProductCategory;
import com.s204000800.springordersystem.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));


        String categoryStr = resultSet.getString("category");//將取出的職
        ProductCategory category = ProductCategory.valueOf(categoryStr);//查詢ENUM是否有傳入參數的值，有就回傳
        product.setCategory(category);

        //product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));


        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setDescription(resultSet.getString("description"));
        product.setCreatedDate(resultSet.getTimestamp("created_date"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));
        product.setProductExist(resultSet.getBoolean("product_exist"));

        return product;
    }
}
