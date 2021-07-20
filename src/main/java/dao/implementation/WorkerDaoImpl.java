package dao.implementation;

import config.DBConnection;
import dao.interfaces.WorkerDao;
import entity.Worker;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class WorkerDaoImpl implements WorkerDao{

    @Override
    public List<Worker> getAll() {
        List<Worker> workers = new LinkedList<>();

        String sql = "SELECT * FROM worker ";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Worker worker = new Worker();
                worker.setId(rs.getInt("id"));
                worker.setFirstName(rs.getString("firstName"));
                worker.setLastName(rs.getString("lastName"));
                worker.setPosition(rs.getString("position"));
                worker.setAge(rs.getInt("age"));
                worker.setRating(rs.getInt("rating"));
                worker.setExperience(rs.getInt("experience"));
                worker.setPhoto(rs.getString("photo"));
                workers.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workers;
    }

    @Override
    public boolean add(Worker worker) throws SQLException, NamingException {
        return false;
    }

    @Override
    public Worker get(int id) throws SQLException, NamingException {
        return null;
    }

    @Override
    public boolean update(Worker worker) throws SQLException, NamingException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        return false;
    }
}
