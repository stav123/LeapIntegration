package com.leapintegration.controller;

import com.leapintegration.constants.Constants;
import com.leapintegration.dao.ProductDAO;
import com.leapintegration.dao.ProductDAOImpl;
import com.leapintegration.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by StefanS on 4/27/15.
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = Constants.HOME, method = RequestMethod.GET)
    public ModelAndView showHome() {

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productService.getProducts());

        return modelAndView;
    }


}
