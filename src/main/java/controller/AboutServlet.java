package controller;

import entity.ProductType;
import service.implementation.ProductTypeServiceImpl;
import service.interfaces.ProductTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/about")
public class AboutServlet extends HttpServlet {
    private final ProductTypeService productTypeService= new ProductTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductType> productTypes = productTypeService.getAllProductTypes();
        req.setAttribute("productTypes", productTypes);
        req.getRequestDispatcher("/pages/aboutCompany.jsp").forward(req, resp);
    }
}
