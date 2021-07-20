package dao.implementation;

import config.DBConnection;
import dao.interfaces.UserDao;
import entity.User;
import enums.UserType;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean add(User user) throws SQLException, NamingException {
        String sql = "INSERT INTO users(firstname,lastname,email,phoneNumber,dataOfBirthday," +
                "password,userType)"
                + "VALUES (?, ?, ?, ?, ?, ?,?)";

        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, user.getFirstname());
        ps.setString(2, user.getLastname());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPhoneNumber());
        ps.setString(5, String.valueOf(user.getDataOfBirthday()));
        ps.setString(6, user.getPassword());
        ps.setString(7, String.valueOf(UserType.USER));


        boolean isAdded = ps.executeUpdate() > 0;
        ps.close();

        return isAdded;
    }

    @Override
    public User get(int id) throws SQLException, NamingException {
        User user = new User();

        String sql = "SELECT * FROM users WHERE id = "+id;

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setDataOfBirthday(rs.getString("dataOfBirthday"));
                user.setPassword(rs.getString("password"));
                user.setUserType(UserType.valueOf(rs.getString("userType")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
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
    public User getUserByEmail(String email) {
        User user = new User();

        String sql = "SELECT * FROM users WHERE email = '"+email+"'";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setDataOfBirthday(rs.getString("dataOfBirthday"));
                user.setPassword(rs.getString("password"));
                user.setUserType(UserType.valueOf(rs.getString("userType")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public String getUserEmailById(int id) {

        String sql = "SELECT us.email FROM users us WHERE us.id= "+id;
        String email = "";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               email=rs.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
}
