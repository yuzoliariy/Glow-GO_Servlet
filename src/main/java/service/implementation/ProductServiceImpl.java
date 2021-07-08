package service.implementation;

import dao.implementation.ProductDaoImpl;
import dao.implementation.ProductTypeDaoImpl;
import dao.interfaces.Dao;
import dao.interfaces.ProductDao;
import entity.Product;
import entity.ProductType;
import service.interfaces.ProductService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public boolean add(Product product) throws SQLException, NamingException {
        return productDao.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public List<Product> getAllProductsByType(int productTypeId) {
        return productDao.getAllProductsByType(productTypeId);
    }

    @Override
    public void addProductToCart(int personId, int productId) {
          productDao.addProductToCart(personId,productId);
    }

    @Override
    public List<Product> getAllProductsInCart(int userId) {
        return productDao.getAllProductsInCart(userId);
    }

    @Override
    public void deleteFromCart(int productId, int userId) {
        productDao.deleteFromCart(productId,userId);
    }

    @Override
    public void clearCart(int userId) {
        productDao.clearCart(userId);
    }
}
