package dao;

import entity.Horse;

import java.sql.SQLException;
import java.util.List;

public interface HorseDao {
    //read
    void add(Horse horse) throws SQLException;
    List<Horse> getAll() throws SQLException;
    Horse getById(int Id) throws SQLException;

    //update
    void update(Horse horse) throws SQLException;

    //delete
    void removeById(int id) throws SQLException;
}
