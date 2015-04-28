package com.leapintegration.dao;

import com.leapintegration.DBUtility.DBUtility;
import com.leapintegration.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by StefanS on 4/27/15.
 */
@Component
public class ProductDAOImpl implements ProductDAO {

    private DBUtility dbUtility;

    @Autowired
    public void setDbUtility(DBUtility dbUtility) {
        this.dbUtility = dbUtility;
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


    public void addProduct(ProductModel productModel) {

        final String sql = "INSERT INTO PRODUCT (PRODUCT_NAME, PRICE, DESCR) VALUES (?,?,?)";
        Connection connection = dbUtility.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, productModel.getProductName());
            ps.setDouble(2, productModel.getPrice());
            ps.setString(3, productModel.getDescription());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(int id) {
        //TODO

    }

    public ProductModel editProduct(int id) {
        //TODO
        return null;
    }

    public List<ProductModel> getAllProducts() {

        return populateList();
    }


}
