package com.leapintegration.dao;

import com.leapintegration.model.ProductModel;

import java.util.List;

/**
 * Created by Tommy on 4/27/2015.
 */
public interface ProductDAO {
    //add, remove, search, edit

    void addProduct(ProductModel productModel);
    void removeProduct(int id);
    ProductModel editProduct(ProductModel ProductModel);
    List<ProductModel> getAllProducts();





}
