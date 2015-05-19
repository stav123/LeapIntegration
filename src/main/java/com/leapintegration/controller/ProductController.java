package com.leapintegration.controller;

import com.leapintegration.constants.Constants;
import com.leapintegration.dao.ProductDAO;
import com.leapintegration.dao.ProductDAOImpl;
import com.leapintegration.model.ProductModel;
import com.leapintegration.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @ModelAttribute("productModel")
    public ProductModel getProductModel() {
        return new ProductModel();
    }

    @RequestMapping(value = Constants.HOME, method = RequestMethod.GET)
    public ModelAndView showHome() {

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productService.getProducts());

        return modelAndView;
    }

    @RequestMapping(value = Constants.ADD, method = RequestMethod.POST)
    public ModelAndView createProduct(@ModelAttribute("productModel") ProductModel productModel) {
        productService.createProduct(productModel);
        ModelAndView modelAndView = new ModelAndView("redirect:home");
        Boolean isAdded = true;
        modelAndView.addObject("isAdded", isAdded);
        return modelAndView;

    }

    @RequestMapping(value = Constants.DELETE, method = RequestMethod.GET)
    public ModelAndView removeProduct(@PathVariable(value = "id") String id) {

        ModelAndView modelAndView = new ModelAndView("redirect:/showProducts");
        int productId = Integer.parseInt(id);
        productService.deleteProduct(productId);
        modelAndView.addObject("deleted", productId);
        return modelAndView;
    }

    @RequestMapping(value = Constants.SHOW_PRODUCTS, method = RequestMethod.GET)
    public ModelAndView showProducts() {

        ModelAndView modelAndView = new ModelAndView("showProducts");
        modelAndView.addObject("products", productService.getProducts());

        return modelAndView;
    }

    @RequestMapping(value = Constants.EDIT, method = RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable(value = "id") String id) {

        ModelAndView modelAndView = new ModelAndView("edit");
        ProductModel productModel = productService.getProductById(Integer.parseInt(id));
        modelAndView.addObject("product", productModel);

        return modelAndView;

    }

    @RequestMapping(value = Constants.UPDATE, method = RequestMethod.POST)
    public ModelAndView updateProduct(@ModelAttribute("productModel") ProductModel productModel) {
        productService.updateProduct(productModel);
        ModelAndView modelAndView = new ModelAndView("redirect:/showProducts");

        return modelAndView;

    }

    @RequestMapping(value = Constants.DELETE_ALL, method = RequestMethod.POST)
    public ModelAndView deleteAll(@RequestParam(value = "checked", required = false) String[] id) {
        if (id == null || id.length == 0) {
            ModelAndView modelAndView = new ModelAndView("redirect:/showProducts");
            modelAndView.addObject("error", "Please select at least one product");
            return modelAndView;
        }
        productService.deleteAllProducts(id);
        return new ModelAndView("redirect:/showProducts");
    }
}