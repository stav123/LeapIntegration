package com.leapintegration.ServiceInterface;

import com.leapintegration.dao.ProductDAO;
import com.leapintegration.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tommy on 4/28/2015.
 */
@Component
public class ServiceInterfaceImpl implements ServiceInterface {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<ProductModel> products = new ArrayList<ProductModel>();
    ProductModel product1 = new ProductModel(1, "product1", 15.00, "testDescr1");
    ProductModel product2 = new ProductModel(2, "product1", 25.00, "testDescr2");
    ProductModel product3 = new ProductModel(3, "product1", 35.00, "testDescr3");
    ProductModel product4 = new ProductModel(4, "product1", 45.00, "testDescr4");

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
