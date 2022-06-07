package com.example.shoplist.config.controllers.implementations;

import java.util.List;

import java.util.List;

import com.example.shoplist.config.models.Product;
import com.example.shoplist.config.services.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class ProductController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/Product")
    public String getAllProduct(){

        return jdbcTemplate.queryForList("select  * from eshopliststdb.new_table").toString();
    }

    @Autowired
    private ProductService productService;

    @GetMapping("/listProducts.html")
    public String showExampleView(Model model)
    {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "/listProducts.html";
    }
    @GetMapping("/")
    public String showAddProduct()
    {

        return "/addProduct.html";
    }

    @PostMapping("/addP")
    public String saveProduct(@RequestParam("file") MultipartFile file,
                              @RequestParam("pname") String name,
                              @RequestParam("price") int price,
                              @RequestParam("desc") String desc)
    {
        productService.saveProductToDB(file, name, desc, price);
        return "redirect:/listProducts.html";
    }

    @GetMapping("/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {

        productService.deleteProductById(id);
        return "redirect:/listProducts.html";
    }

    @PostMapping("/changeName")
    public String changePname(@RequestParam("id") Long id,
                              @RequestParam("newPname") String name)
    {
        productService.chageProductName(id, name);
        return "redirect:/listProducts.html";
    }
    @PostMapping("/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
                                    @RequestParam("newDescription") String description)
    {
        productService.changeProductDescription(id, description);
        return "redirect:/listProducts.html";
    }

    @PostMapping("/changePrice")
    public String changePrice(@RequestParam("id") Long id ,
                              @RequestParam("newPrice") int price)
    {
        productService.changeProductPrice(id, price);
        return "redirect:/listProducts.html";
    }
}