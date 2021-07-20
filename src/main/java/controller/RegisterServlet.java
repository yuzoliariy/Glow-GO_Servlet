package controller;

import entity.User;
import enums.UserType;
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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        String dataOfBirthday = req.getParameter("dataOfBirthday");
        String passwordToHash = req.getParameter("password");
        String photo = req.getParameter("photo");

        try {
            String securePassword = HashPasswordUtil.hashPassword(passwordToHash);
            UserService userService = new UserServiceImpl();
            User user = userService.getUserByEmail(email);

            if (user.getEmail() == null) {
                user = new User(firstName, lastName, email, phoneNumber, dataOfBirthday, securePassword, UserType.USER,photo);
                userService.add(user);
                user = userService.getUserByEmail(email);

                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                System.out.println("УСПІШНО ЗАРЕЄСТРОВАНО");

                resp.sendRedirect("/");
            } else {
                resp.sendError(403);
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

    }
}
