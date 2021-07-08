package dao.implementation;

import config.DBConnection;
import dao.interfaces.ProductDao;
import entity.Product;
import enums.UserType;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public boolean add(Product product) throws SQLException, NamingException {
        String sql = "INSERT INTO products(name,price,brand,description,capacity," +
                "madeIn,productTypeId,photo)"
                + "VALUES (?, ?, ?, ?, ?, ?,?,?)";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setString(2, String.valueOf(product.getPrice()));
        ps.setString(3, product.getBrand());
        ps.setString(4, product.getDescription());
        ps.setString(5, String.valueOf(product.getCapacity()));
        ps.setString(6, product.getMadeIn());
        ps.setString(7, String.valueOf(product.getProductTypeId()));
        ps.setString(8, product.getPhoto());



        boolean isAdded = ps.executeUpdate() > 0;
        ps.close();

        return isAdded;
    }

    @Override
    public Product get(int id) throws SQLException, NamingException {
        return null;
    }

    @Override
    public boolean update(Product product) throws SQLException, NamingException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new LinkedList<>();

        String sql = "SELECT * FROM products ";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setBrand(rs.getString("brand"));
                product.setDescription(rs.getString("description"));
                product.setCapacity(rs.getDouble("capacity"));
                product.setMadeIn(rs.getString("madeIn"));
                product.setProductTypeId(rs.getInt("productTypeId"));
                product.setPhoto(rs.getString("photo"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public List<Product> getAllProductsByType(int productTypeId) {
        List<Product> products = new LinkedList<>();

        String sql = "SELECT * FROM products WHERE productTypeId=" + productTypeId;

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setBrand(rs.getString("brand"));
                product.setDescription(rs.getString("description"));
                product.setCapacity(rs.getDouble("capacity"));
                product.setMadeIn(rs.getString("madeIn"));
                product.setProductTypeId(rs.getInt("productTypeId"));
                product.setPhoto(rs.getString("photo"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public void addProductToCart(int personId, int productId) {
        String sql = "INSERT INTO cart (userId, productId) VALUES(?,?)";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, personId);
            ps.setInt(2, productId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProductsInCart(int userId) {
        List<Product> products = new LinkedList<>();

        String sql = "select * from products pr inner join cart ct on pr.id = ct.productId where ct.userId=?";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setPrice(rs.getInt("price"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setBrand(rs.getString("brand"));
                product.setMadeIn(rs.getString("madeIn"));
                product.setProductTypeId(rs.getInt("productTypeId"));
                product.setCapacity(rs.getDouble("capacity"));
                product.setPhoto(rs.getString("photo"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public void deleteFromCart(int productId, int userId) {
        String sql = "delete from cart where productId=? and userId=?";

        try(PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, productId);
            ps.setInt(2, userId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearCart(int userId) {
        String sql = "delete from cart where userId=?";

        try(PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
