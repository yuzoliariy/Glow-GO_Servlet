package controller;

import com.google.gson.Gson;
import entity.ProductType;
import service.implementation.ProductTypeServiceImpl;
import service.interfaces.ProductTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/productTypes")
public class ProductsTypeServlet extends HttpServlet {
    private final ProductTypeService productTypeService = new ProductTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ProductType> productTypes = productTypeService.getAllProductTypes();
        request.setAttribute("categories", productTypes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/category.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<ProductType> listCatagory = productTypeService.getAllProductTypes();
        String json = new Gson().toJson(listCatagory);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

    }
}
