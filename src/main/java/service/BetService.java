package service;

import entity.Bet;

import java.sql.SQLException;
import java.util.List;

public interface BetService {

    void add(Bet bet) throws SQLException;
    List<Bet> getAll() throws SQLException;
    Bet getById(int id) throws SQLException;
    void update(Bet bet) throws SQLException;
    void remove(Bet bet) throws SQLException;
    void removeById(int id) throws SQLException;


}
