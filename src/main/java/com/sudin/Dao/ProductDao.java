package com.sudin.Dao;

import com.sudin.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private List<Product> productList;

    public List<Product> getProductList(){
        Product product=new Product();
        product.setProductName("Guitar");
        product.setProductCatgory("Instruments");
        product.setProductDescription("This is a fender strat guitar");
        product.setProductPrice(1000);
        product.setProductCondition("new");
        product.setProductStatus("Active");
        product.setUnitStock(11);
        product.setProductManufacturer("Fender");

        productList=new ArrayList<Product>();
        productList.add(product);

        return productList;
    }
}
