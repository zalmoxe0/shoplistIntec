package com.example.shoplist.config.controllers.implementations;

import java.util.List;

import com.example.shoplist.config.models.Product;
import com.example.shoplist.config.repositories.ProductRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetViewController {
    @Autowired
    private ProductRepositry productRepo;

    @RequestMapping(value = "/addProduct",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView returnAddProduct()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addProduct");
        //mv.addObject("var", "halim");
        return mv;

    }

    @RequestMapping(value = "/listProduct",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView returnListProduct()
    {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productRepo.findAll();
        mv.setViewName("listProducts");
        mv.addObject("products", products);
        return mv;

    }

}