package controller;

import com.google.gson.Gson;
import entity.Product;
import service.implementation.ProductServiceImpl;
import service.interfaces.ProductService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> productList = productService.getAllProducts();
        request.setAttribute("allProducts", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/category.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int typeId = Integer.parseInt(req.getParameter("typeId"));

        List<Product> productList = productService.getAllProductsByType(typeId);

        req.setAttribute("products", productList);
        String json = new Gson().toJson(productList);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

    }
}
