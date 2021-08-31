package dao;

import entity.Bet;
import entity.GameFund;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameFundDaoImpl extends ConnectionManager implements GameFundDao {

    Connection connection = getConnection();

    @Override
    public void add(GameFund gameFund) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO \"GameFund\" (user_id, plus_minus) VALUES(?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, gameFund.getUser_id());
            preparedStatement.setInt(2, gameFund.getPlus_minus());

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
    public List<GameFund> getAll() throws SQLException {
        PreparedStatement statement = null;
        List<GameFund> gameFundList = new ArrayList<>();
        String sql = "SELECT user_id, plus_minus FROM \"GameFund\"";
        try {

            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                GameFund gameFund = new GameFund();
                gameFund.setId(resultSet.getInt("id"));
                gameFund.setUser_id(resultSet.getInt("user_id"));
                gameFund.setPlus_minus(resultSet.getInt("plus_minus"));

                gameFundList.add(gameFund);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return gameFundList;
    }

    @Override
    public GameFund getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, user_id, plus_minus FROM \"GameFund\" WHERE id = ?";

        GameFund gameFund = new GameFund();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                gameFund.setId(resultSet.getInt("id"));
                gameFund.setUser_id(resultSet.getInt("user_id"));
                gameFund.setPlus_minus(resultSet.getInt("plus_minus"));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return gameFund;
    }

    @Override
    public int getSum() throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT SUM(plus_minus) as summ FROM \"GameFund\"";
        int sum = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            sum = resultSet.getInt("summ");
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return sum;
    }

    @Override
    public void update(GameFund gameFund) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE \"GameFund\" SET user_id = ?, plus_minus = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, gameFund.getUser_id());
            preparedStatement.setInt(2, gameFund.getPlus_minus());
            preparedStatement.setInt(3, gameFund.getId());

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
    public void remove(GameFund gameFund) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM \"GameFund\" WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, gameFund.getId());

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
