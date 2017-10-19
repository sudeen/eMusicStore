package com.sudin.Controllers;

import com.sudin.Dao.ProductDao;
import com.sudin.Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    private ProductDao productDao = new ProductDao();


    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> productList=productDao.getProductList();
        Product product=productList.get(0);
        model.addAttribute(product);

        return "productList";
    }

}
