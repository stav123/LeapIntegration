package com.leapintegration.service;

import com.leapintegration.model.ProductModel;

import java.util.List;

/**
 * Created by Tommy on 4/28/2015.
 */
public interface ProductService {


    void createProduct(ProductModel productModel);
    void deleteProduct(int id);
    void updateProduct(ProductModel productModel);
    List<ProductModel> getProducts();
    ProductModel getProductById(int id);
}
