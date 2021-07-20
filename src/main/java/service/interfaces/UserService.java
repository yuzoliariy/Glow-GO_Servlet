package service.interfaces;

import entity.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<User> getAll() throws SQLException, NamingException;

    boolean add(User user) throws SQLException, NamingException; // C

    User get(int id) throws SQLException, NamingException; // R

    boolean update(User user) throws SQLException, NamingException; // U

    boolean delete(int id) throws SQLException, NamingException; // D

    User getUserByEmail(String email) throws SQLException, NamingException;

    String getUserEmailById(int id);

}
