package com.s204000800.springordersystem.dao;

import com.s204000800.springordersystem.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
