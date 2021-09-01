package dao;


import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //read
    void add(User user) throws SQLException;

    List<User> getAll() throws SQLException;

    User getById(int Id) throws SQLException;


    //update
    void update(User user) throws SQLException;

    void updateCash(int id, int cash) throws SQLException;

    //delete
    void removeById(int id) throws SQLException;


}
