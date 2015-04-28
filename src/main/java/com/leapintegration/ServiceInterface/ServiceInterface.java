package com.leapintegration.ServiceInterface;

import com.leapintegration.model.ProductModel;

import java.util.List;

/**
 * Created by Tommy on 4/28/2015.
 */
public interface ServiceInterface {
        //add, remove, search,
        ProductModel addProduct(ProductModel productModel);
    boolean removeProduct(int id);
    ProductModel editProduct(int id);
    List<ProductModel> getAllProducts();
}
