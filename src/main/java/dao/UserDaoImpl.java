package dao;

import util.ConnectionManager;
import entity.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends ConnectionManager implements UserDao {

    Connection connection = getConnection();


    @Override
    public void add(User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO \"Users\" (first_name, last_name, user_dob, user_cash) VALUES(?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setDate(3, user.getDob());
            preparedStatement.setInt(4, user.getUser_cash());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {

                preparedStatement.close();
            }
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        PreparedStatement statement = null;
        List<User> usersList = new ArrayList<>();
        String sql = "SELECT user_id, first_name, last_name, user_dob, user_cash FROM \"Users\"";
        try {

            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setDob(resultSet.getDate("user_dob"));
                user.setUser_cash(resultSet.getInt("user_cash"));

                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return usersList;
    }

    @Override
    public User getById(int Id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT user_id, first_name, last_name, user_dob, user_cash FROM \"Users\" WHERE user_id = ?";

        User user = new User();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("user_id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setDob(resultSet.getDate("user_dob"));
                user.setUser_cash(resultSet.getInt("user_cash"));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (preparedStatement != null) {

                preparedStatement.close();

            }
        }
        return user;
    }


    @Override
    public void update(User user) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE \"Users\" SET first_name = ?, last_name = ?, user_dob = ?, user_cash = ? WHERE user_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setDate(3, user.getDob());
            preparedStatement.setInt(4, user.getUser_cash());
            preparedStatement.setInt(5, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {

                preparedStatement.close();

            }
        }

    }

    @Override
    public void updateCash(int id, int cash) throws SQLException {
        Statement statement = null;

        String sql = "UPDATE \"Users\" SET user_cash = " + cash + " WHERE user_id = " + id;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();

            }
        }
    }

    @Override
    public void removeById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM \"Users\" WHERE user_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }
}

