package dao;

import entity.Horse;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorseDaoImpl extends ConnectionManager implements HorseDao {

    Connection connection = getConnection();

    @Override
    public void add(Horse horse) throws SQLException {

        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO \"Horses\" (horse_name, coefficient) VALUES(?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, horse.getHorse_name());
            preparedStatement.setDouble(2, horse.getCoefficient());

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
    public List<Horse> getAll() throws SQLException {
        PreparedStatement statement = null;
        List<Horse> horseList = new ArrayList<>();
        String sql = "SELECT horse_id, horse_name, coefficient FROM \"Horses\"";
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Horse horse = new Horse();
                horse.setId(resultSet.getInt("horse_id"));
                horse.setHorse_name(resultSet.getString("horse_name"));
                horse.setCoefficient(resultSet.getDouble("coefficient"));

                horseList.add(horse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {

                statement.close();

            }
        }
        return horseList;
    }

    @Override
    public Horse getById(int Id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT horse_id, horse_name, coefficient FROM \"Horses\" WHERE horse_id = ?";

        Horse horse = new Horse();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                horse.setId(resultSet.getInt("horse_id"));
                horse.setHorse_name(resultSet.getString("horse_name"));
                horse.setCoefficient(resultSet.getDouble("coefficient"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (preparedStatement != null) {

                preparedStatement.close();
            }
        }
        return horse;
    }

    @Override
    public void update(Horse horse) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE \"Horses\" SET horse_name = ?, coefficient = ? WHERE horse_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, horse.getHorse_name());
            preparedStatement.setDouble(2, horse.getCoefficient());
            preparedStatement.setInt(3, horse.getId());

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
    public void removeById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM \"Horses\" WHERE horse_id = ?";

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