package service.implementation;

import dao.implementation.ProductTypeDaoImpl;
import dao.interfaces.Dao;
import entity.ProductType;
import service.interfaces.ProductTypeService;

import java.util.List;

public class ProductTypeServiceImpl implements ProductTypeService {
    private final Dao<ProductType> productTypeDao = new ProductTypeDaoImpl();
    @Override
    public List<ProductType> getAllProductTypes() {
        return productTypeDao.getAll();
    }
}
