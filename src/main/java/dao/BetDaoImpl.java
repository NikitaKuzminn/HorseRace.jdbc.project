package dao;

import util.ConnectionManager;
import entity.Bet;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BetDaoImpl extends ConnectionManager implements BetDao {

    Connection connection = getConnection();

    @Override
    public void add(Bet bet) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO \"Bets\" (user_id, horse, rate_value) VALUES(?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, bet.getUser());
            preparedStatement.setInt(2, bet.getHorse());
            preparedStatement.setInt(3, bet.getRate_value());

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
    public List<Bet> getAll() throws SQLException {
        PreparedStatement statement = null;
        List<Bet> betsList = new ArrayList<>();
        String sql = "SELECT id, user_id, horse, rate_value FROM \"Bets\"";
        try {

            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Bet bet = new Bet();
                bet.setId(resultSet.getInt("id"));
                bet.setUser(resultSet.getInt("user_id"));
                bet.setHorse(resultSet.getInt("horse"));
                bet.setRate_value(resultSet.getInt("rate_value"));

                betsList.add(bet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }

        }

        return betsList;
    }


    @Override
    public Bet getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, user_id, horse, rate_value FROM \"Bets\" WHERE id = ?";

        Bet bet = new Bet();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bet.setId(resultSet.getInt("id"));
                bet.setUser(resultSet.getInt("user_id"));
                bet.setHorse(resultSet.getInt("horse"));
                bet.setRate_value(resultSet.getInt("rate_value"));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();

            }
        }
        return bet;
    }

    @Override
    public void update(Bet bet) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE \"Bets\" SET user_id = ?, horse = ?, rate_value = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bet.getUser());
            preparedStatement.setInt(2, bet.getHorse());
            preparedStatement.setLong(3, bet.getRate_value());
            preparedStatement.setInt(4, bet.getId());

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
    public void remove(Bet bet) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM \"Bets\" WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, bet.getId());

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

        String sql = "DELETE FROM \"Bets\" WHERE id = ?";

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
