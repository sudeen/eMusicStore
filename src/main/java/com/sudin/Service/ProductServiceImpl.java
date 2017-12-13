package com.sudin.Service;

import com.sudin.Dao.ProductDao;
import com.sudin.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Map<String, Object>> productList() {
        List<Product> response = productDao.getAllProduct();
        List<Map<String,Object>> finalList = new ArrayList<>();
        for (Object object : response) {
            Object[] objects = (Object[]) object;
            Integer id = (Integer) objects[0];
            String productCategory = (String) objects[1];
            String productCondition = (String) objects[2];
            String productDescription = (String) objects[3];
            String productManufacturer = (String) objects[4];
            String productName = (String) objects[5];
            Double productPrice = (Double) objects[6];
            String productStatus = (String) objects[7];
            Integer unitStock = (Integer) objects[8];
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("Id", id);
            map.put("ProductName", productName);
            map.put("ProductCategory", productCategory);
            map.put("ProductCondition", productCondition);
            map.put("ProductDescription", productDescription);
            map.put("ProductManufacturer", productManufacturer);
            map.put("ProductPrice", productPrice);
            map.put("ProductStatus", productStatus);
            map.put("UnitStock", unitStock);
            finalList.add(map);
        }
        return finalList;
    }

    @Override
    public List<Map<String, Object>> productById(int id) {
        List<Product> response=productDao.getProductById(id);
        List<Map<String,Object>> finalList = new ArrayList<>();
        for (Object object : response) {
            Object[] objects = (Object[]) object;
            String productCategory = (String) objects[0];
            String productCondition = (String) objects[1];
            String productDescription = (String) objects[2];
            String productManufacturer = (String) objects[3];
            String productName = (String) objects[4];
            Double productPrice = (Double) objects[5];
            String productStatus = (String) objects[6];
            Integer unitStock = (Integer) objects[7];
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("ProductName", productName);
            map.put("ProductCategory", productCategory);
            map.put("ProductCondition", productCondition);
            map.put("ProductDescription", productDescription);
            map.put("ProductManufacturer", productManufacturer);
            map.put("ProductPrice", productPrice);
            map.put("ProductStatus", productStatus);
            map.put("UnitStock", unitStock);
            finalList.add(map);
        }
        return finalList;    }
}
