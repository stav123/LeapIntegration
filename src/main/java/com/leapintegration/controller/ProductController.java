package com.leapintegration.controller;

import com.leapintegration.dao.ProductDAO;
import com.leapintegration.dao.ProductDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by StefanS on 4/27/15.
 */

@Controller
public class ProductController {


    @Autowired
    private ProductDAO productDAO;

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @RequestMapping(value = "/home")
    public ModelAndView showHome() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = {"/getProducts"})
    public ModelAndView getProducts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", productDAO.getAllProducts());
        modelAndView.addObject("message", "helloTest");
        modelAndView.setViewName("products");
        return modelAndView;
    }


}
