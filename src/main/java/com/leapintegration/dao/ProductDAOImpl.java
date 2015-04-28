package com.leapintegration.dao;

import com.leapintegration.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by StefanS on 4/27/15.
 */
@Component
public class ProductDAOImpl implements ProductDAO {


    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<ProductModel> products = new ArrayList<ProductModel>();
    ProductModel product1 = new ProductModel(1, "product1", 10.00, "testDescr1");
    ProductModel product2 = new ProductModel(2, "product2", 20.00, "testDescr2");
    ProductModel product3 = new ProductModel(3, "product3", 30.00, "testDescr3");
    ProductModel product4 = new ProductModel(4, "product4", 40.00, "testDescr4");

    List<ProductModel> populateList() {
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        return products;
    }


    public ProductModel addProduct(ProductModel productModel) {
        return null;
    }

    public boolean removeProduct(int id) {
        return false;
    }

    public ProductModel editProduct(int id) {
        return null;
    }

    public List<ProductModel> getAllProducts() {

        return populateList();
    }


}
