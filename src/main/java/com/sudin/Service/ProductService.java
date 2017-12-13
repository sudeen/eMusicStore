package com.sudin.Service;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Map<String, Object>> productList();

    List<Map<String, Object>> productById(int id);
}
