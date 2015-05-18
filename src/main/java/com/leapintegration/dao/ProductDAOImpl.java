package com.leapintegration.dao;

import com.leapintegration.DBUtility.DBUtility;
import com.leapintegration.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

//    List<ProductModel> products = new ArrayList<ProductModel>();
//    ProductModel product1 = new ProductModel(1, "product1", 10.00, "testDescr1");
//    ProductModel product2 = new ProductModel(2, "product2", 20.00, "testDescr2");
//    ProductModel product3 = new ProductModel(3, "product3", 30.00, "testDescr3");
//    ProductModel product4 = new ProductModel(4, "product4", 40.00, "testDescr4");
//
//    List<ProductModel> populateList() {
//        products.add(product1);
//        products.add(product2);
//        products.add(product3);
//        products.add(product4);
//        return products;
//    }

    public void addProduct(ProductModel productModel) {

        final String sql = "INSERT INTO PRODUCT (PRODUCTNAME, PRICE, DESCRIPTION) VALUES (?,?,?)";
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

        final String sql = "DELETE FROM PRODUCT WHERE ID = ?";
        Connection connection = dbUtility.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void editProduct(ProductModel productModel) {

        String sql = "UPDATE PRODUCT SET description=?, productName=?, price=? WHERE id=?";

        Connection connection = dbUtility.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, productModel.getDescription());
            ps.setString(2, productModel.getProductName());
            ps.setDouble(3, productModel.getPrice());
            ps.setInt(4, productModel.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ProductModel> getAllProducts() {
        List<ProductModel> products = new ArrayList<ProductModel>();
        final String sql = "SELECT * FROM PRODUCT";
        Connection connection = dbUtility.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel productModel = new ProductModel();
                productModel.setId(rs.getInt("id"));
                productModel.setProductName(rs.getString("productName"));
                productModel.setPrice(rs.getLong("price"));
                productModel.setDescription(rs.getString("description"));
                products.add(productModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public ProductModel getProductById(int id) {

        final String sql = "SELECT * FROM PRODUCT WHERE ID=?";
        ProductModel productModel = new ProductModel();
        Connection connection = dbUtility.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productModel.setId(rs.getInt("id"));
                productModel.setProductName(rs.getString("productName"));
                productModel.setPrice(rs.getLong("price"));
                productModel.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productModel;
    }

    public void deleteAllProducts(String[] id) {

        final String sql = "DELETE FROM PRODUCT WHERE ID=?";
        Connection connection = dbUtility.getConnection();
        PreparedStatement ps = null;
        for(int i = 0; i <= id.length; i++){
            try {
                ps = connection.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(id[i]));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }


}
