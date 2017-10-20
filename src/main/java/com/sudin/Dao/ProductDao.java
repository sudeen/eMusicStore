package com.sudin.Dao;

import com.sudin.Model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private List<Product> productList;

    public List<Product> getProductList() {
        Product product = new Product();
        product.setProductId("p123");
        product.setProductName("Guitar");
        product.setProductCatgory("Instruments");
        product.setProductDescription("This is a fender strat guitar");
        product.setProductPrice(1000);
        product.setProductCondition("new");
        product.setProductStatus("Active");
        product.setUnitStock(11);
        product.setProductManufacturer("Fender");

        Product product1 = new Product();
        product1.setProductId("q123");
        product1.setProductName("Drum");
        product1.setProductCatgory("Instruments");
        product1.setProductDescription("This is a Drummer");
        product1.setProductPrice(2000);
        product1.setProductCondition("new");
        product1.setProductStatus("Active");
        product1.setUnitStock(10);
        product1.setProductManufacturer("Zender");

        Product product2 = new Product();
        product2.setProductId("r123");
        product2.setProductName("Record");
        product2.setProductCatgory("Record");
        product2.setProductDescription("This is an awesome recorder");
        product2.setProductPrice(100);
        product2.setProductCondition("new");
        product2.setProductStatus("Active");
        product2.setUnitStock(5);
        product2.setProductManufacturer("Tips");


        productList = new ArrayList<Product>();
        productList.add(product);
        productList.add(product1);
        productList.add(product2);

        return productList;
    }

    public Product getProductById(String productId) throws IOException {
        for (Product product : getProductList()) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        throw new IOException("No Product Found");
    }
}
