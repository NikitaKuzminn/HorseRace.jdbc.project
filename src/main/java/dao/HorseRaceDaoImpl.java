package dao;

import entity.HorseRace;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorseRaceDaoImpl extends ConnectionManager implements HorseRaceDao {

    Connection connection = getConnection();


    @Override
    public void add(HorseRace horseRace) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO \"HorseRace\" (winner) VALUES(?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, horseRace.getWinner());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<HorseRace> getAll() {
        PreparedStatement statement = null;
        List<HorseRace> horseRaceList = new ArrayList<>();
        String sql = "SELECT id, winner FROM \"HorseRace\"";
        try {

            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                HorseRace horseRace = new HorseRace();
                horseRace.setId(resultSet.getInt("id"));
                horseRace.setWinner(resultSet.getString("winner"));


                horseRaceList.add(horseRace);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return horseRaceList;
    }

    @Override
    public HorseRace getById(int Id) {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, winner  FROM \"HorseRace\" WHERE id = ?";

        HorseRace horseRace = new HorseRace();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                horseRace.setId(resultSet.getInt("user_id"));
                horseRace.setWinner(resultSet.getString("winner"));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return horseRace;
    }


    @Override
    public void update(HorseRace horseRace) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE \"HorseRace\" SET winner = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, horseRace.getWinner());
            preparedStatement.setInt(2, horseRace.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void remove(HorseRace horseRace) {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM \"HorseRace\" WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, horseRace.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
