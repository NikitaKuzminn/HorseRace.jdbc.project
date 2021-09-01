package dao;

import entity.Bet;

import java.sql.SQLException;
import java.util.List;

public interface BetDao {
    //read
    void add(Bet bet) throws SQLException;

    List<Bet> getAll() throws SQLException;

    Bet getById(int id) throws SQLException;

    //update
    void update(Bet bet) throws SQLException;

    //delete
    void remove(Bet bet) throws SQLException;

    void removeById(int id) throws SQLException;
}
