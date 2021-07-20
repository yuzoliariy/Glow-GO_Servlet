package controller;

import entity.Product;
import service.implementation.ProductServiceImpl;
import service.implementation.UserServiceImpl;
import service.interfaces.ProductService;
import service.interfaces.UserService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@WebServlet("/emptyBasket")
public class EmptyBasketServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");

        productService.clearCart(userId);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        List<Product> productList = productService.getAllProductsInCart(userId);

        List<String> productsInfo = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            productsInfo.add(i, "Назва: " + productList.get(i).getName() + " | " + "Brand: "
                    + productList.get(i).getBrand() + " | " + "Ціна: " + productList.get(i).getPrice());
        }

        StringBuilder orderInfo = new StringBuilder();
        for (String s : productsInfo) {
            orderInfo.append(s).append("\n");
        }

        int totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }

        orderInfo.append("Загальна сума до оплати: ").append(totalPrice).append(" грн.");

        long orderNumber = (long) (10000 + Math.random() * 10000);

        final Properties properties = new Properties();
        properties.load(EmptyBasketServlet.class.getClassLoader().getResourceAsStream("mail.properties"));

        String email = userService.getUserEmailById(userId);

        try {
            Session mailSession = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress("yuliazoriy030202@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Дякуємо за замовлення!");
            message.setText("№ замовлення: " + orderNumber + "\n" +
                    "Дата замовлення: " + new Date() + "\n" +
                    "Реквізити оплати: 5375 4141 0550 2925\n" + orderInfo);

            Transport tr = mailSession.getTransport();
            tr.connect(null,  "Yulia1703Zoriy");
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();
            productService.clearCart(userId);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
