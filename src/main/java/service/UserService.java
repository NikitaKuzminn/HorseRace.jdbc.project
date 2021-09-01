package service;

import entity.Bet;
import entity.User;


import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void add(User user) throws SQLException;

    List<User> getAll() throws SQLException;

    User getById(int Id) throws SQLException;

    void update(User user) throws SQLException;

    void updateCash(int id, int cash) throws SQLException;

    void removeById(int Id) throws SQLException;

}
