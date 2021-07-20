package controller;

import entity.Product;
import org.apache.commons.io.FileUtils;
import service.implementation.ProductServiceImpl;
import service.interfaces.ProductService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/addProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        double capacity = Double.parseDouble(req.getParameter("capacity"));
        String description = req.getParameter("description");
        String brand = req.getParameter("brand");
        String madeIn = req.getParameter("madeIn");
        int productTypeId = Integer.parseInt(req.getParameter("productTypeId"));
        String photo = req.getParameter("photo");

        try {

            ProductService productService = new ProductServiceImpl();
            File source = new File(photo);
            File dest = new File("\\images\\");
            try {
                FileUtils.copyDirectory(source, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Product product = new Product(name, price, capacity, description,brand, madeIn, productTypeId,photo);
            productService.add(product);

            HttpSession session = req.getSession();
            session.setAttribute("product", product);
            System.out.println("YOU ADDED NEW PRODUCT");

            resp.sendRedirect("/");
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

    }

}

