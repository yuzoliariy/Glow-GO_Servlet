package controller;

import entity.Product;
import entity.Worker;
import service.implementation.WorkerServiceImpl;
import service.interfaces.WorkerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/workers")
public class WorkerServlet extends HttpServlet {
    private final WorkerService workerService = new WorkerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Worker> workerList = workerService.getAll();
        req.setAttribute("workers",workerList );
        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/workers.jsp");
        dispatcher.forward(req, resp);
    }
}
