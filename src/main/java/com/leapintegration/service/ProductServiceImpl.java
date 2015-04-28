package com.leapintegration.service;

import com.leapintegration.dao.ProductDAO;
import com.leapintegration.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by StefanS on 4/27/15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void createProduct(ProductModel productModel) {
        productDAO.addProduct(productModel);
    }

    public void deleteProduct(int id) {
        productDAO.removeProduct(id);
    }

    public void updateProduct(ProductModel productModel) {
        productDAO.editProduct(productModel);
    }

    public List<ProductModel> getProducts() {
        return productDAO.getAllProducts();
    }

    public ProductModel getProductById(int id) {
        return productDAO.getProductById(id);
    }
}
