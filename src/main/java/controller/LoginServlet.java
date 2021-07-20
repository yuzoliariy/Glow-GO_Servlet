package controller;

import entity.User;
import service.implementation.UserServiceImpl;
import service.interfaces.UserService;
import utils.HashPasswordUtil;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getSession(false).getAttribute("user"));
        req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String passwordToHash = req.getParameter("password");

        try {
            UserService personService = new UserServiceImpl();
            User user = personService.getUserByEmail(email);

            if (user.getEmail() != null) {

                boolean validPassword = HashPasswordUtil.checkPassword(passwordToHash, user.getPassword());

                if (validPassword) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    System.out.println("successful login");
                } else {
                    resp.sendError(401);
                }
            } else {
                resp.sendError(403);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();

        }
    }
}
