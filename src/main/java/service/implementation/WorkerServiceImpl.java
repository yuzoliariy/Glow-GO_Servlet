package service.implementation;

import dao.implementation.WorkerDaoImpl;
import dao.interfaces.WorkerDao;
import entity.Product;
import entity.Worker;
import service.interfaces.WorkerService;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {

    private final WorkerDao workerDao = new WorkerDaoImpl();

    @Override
    public List<Worker> getAll() {
        return workerDao.getAll();
    }
}
