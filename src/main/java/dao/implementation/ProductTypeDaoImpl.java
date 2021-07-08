package dao.implementation;

import config.DBConnection;
import dao.interfaces.Dao;
import entity.ProductType;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductTypeDaoImpl implements Dao<ProductType> {
    @Override
    public List<ProductType> getAll() {
        List<ProductType> productTypes = new LinkedList<>();


        String sql = "SELECT * FROM productstype ORDER BY type";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductType productType = new ProductType();
                productType.setId(rs.getInt("id"));
                productType.setType(rs.getString("type"));
                productTypes.add(productType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productTypes;
    }

    @Override
    public boolean add(ProductType productType) throws SQLException, NamingException {
        return false;
    }

    @Override
    public ProductType get(int id) throws SQLException, NamingException {
        return null;
    }

    @Override
    public boolean update(ProductType productType) throws SQLException, NamingException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        return false;
    }

}
