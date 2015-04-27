package com.leapintegration.dao;

import com.leapintegration.model.ProductModel;

import java.util.List;

/**
 * Created by Tommy on 4/27/2015.
 */
public interface ProductDAO {
    //add, remove, search, edit

    ProductModel addProduct(ProductModel productModel);
    boolean removeProduct(int id);
    ProductModel editProduct(int id);
    List<ProductModel> getAllProducts();





}
