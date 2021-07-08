package service.interfaces;

import entity.Product;
import entity.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    boolean add(Product product) throws SQLException, NamingException;

    List<Product> getAllProducts();

    List<Product> getAllProductsByType(int productTypeId);

    void addProductToCart(int personId, int productId);

    List<Product> getAllProductsInCart(int userId);

    void deleteFromCart(int productId, int userId);

    void clearCart(int userId);

}
