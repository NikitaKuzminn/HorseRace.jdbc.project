package dao;

import entity.GameFund;

import java.sql.SQLException;
import java.util.List;

public interface GameFundDao {

    void add(GameFund gameFund) throws SQLException;

    List<GameFund> getAll() throws SQLException;

    GameFund getById(int id) throws SQLException;

    int getSum() throws SQLException;

    //update
    void update(GameFund gameFund) throws SQLException;

    //delete
    void remove(GameFund gameFund) throws SQLException;


}

