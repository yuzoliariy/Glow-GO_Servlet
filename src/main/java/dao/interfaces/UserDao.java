package dao.interfaces;

import entity.User;

import java.util.List;

public interface UserDao extends Dao<User> {
    User getUserByEmail(String email);

    String getUserEmailById(int id);

}
