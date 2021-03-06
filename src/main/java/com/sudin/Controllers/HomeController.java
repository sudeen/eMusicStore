package com.sudin.Controllers;

import com.sudin.Dao.ProductDao;
import com.sudin.Model.Product;
import com.sudin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private Path path;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/productList")
    public String getProducts(Model model) {
//        List<Product> productLists = productDao.getAllProduct();
        List<Map<String, Object>> productList=productService.productList();
//        model.addAttribute("products", productDao.getAllProduct());
        model.addAttribute("products", productList);
        return "productList";
    }

    @RequestMapping(value = "/productList/viewProducts/{productId}")
    public String viewProduct(@PathVariable int productId,
                              Model model) {
        List<Map<String, Object>> products=productService.productById(productId);
//        Product product = productDao.getProductById(productId);
        model.addAttribute("product",products);

        return "viewProducts";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Map<String, Object>> productList = productService.productList();
        model.addAttribute("products", productList);

        return "productInventory";
    }


    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("Instrument");
        product.setProductCondition("New");
        product.setProductStatus("Active");
//        productDao.addProduct(product);

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product,
                                 HttpServletRequest request,Model model) {
        productDao.addProduct(product);
//        System.out.println("add product phase");
//        System.out.println("product " +new Gson().toJson(product));

/*        MultipartFile productImage=product.getProductImage();
        String rootDirectory=request.getSession().getServletContext().getRealPath("/");
//        Here to use this Paths.get function I needed to change the language level to 7
        path= Paths.get(rootDirectory + "\\webapp\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");

        if (productImage!=null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }
            catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed",e);
            }
        }*/

        System.out.println("product id " +product.getProductId());
        MultipartFile productImage=product.getProductImage();

            try{
                byte[] bytes = productImage.getBytes();
                String name = product.getProductId() + ".png";
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("/home/s-k-ii-p-s/Java-Apps/eMusicStore/src/main/webapp/WEB-INF/resources/images/" + name)));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        model.addAttribute("product",product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model) {
        productDao.deleteProduct(id);

        return "redirect:/admin/productInventory";
    }

}
