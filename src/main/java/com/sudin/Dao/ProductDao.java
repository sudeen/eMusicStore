package com.sudin.Dao;

import com.sudin.Model.Product;

import java.util.List;

public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProduct();

    void deleteProduct(int id);
}
