package service.implementation;

import dao.implementation.UserDaoImpl;
import dao.interfaces.UserDao;
import entity.User;
import service.interfaces.UserService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    final private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getAll() throws SQLException, NamingException {
        return null;
    }

    @Override
    public boolean add(User user) throws SQLException, NamingException {
        return userDao.add(user);
    }

    @Override
    public User get(int id) throws SQLException, NamingException {
        return userDao.get(id);
    }

    @Override
    public boolean update(User user) throws SQLException, NamingException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        return false;
    }

    @Override
    public User getUserByEmail(String email) throws SQLException, NamingException {
        return userDao.getUserByEmail(email);
    }

    @Override
    public String getUserEmailById(int id) {
        return userDao.getUserEmailById(id);
    }
}
