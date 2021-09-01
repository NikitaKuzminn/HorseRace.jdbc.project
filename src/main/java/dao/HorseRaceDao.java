package dao;


import entity.HorseRace;

import java.sql.SQLException;
import java.util.List;

public interface HorseRaceDao {
    //read
    void add(HorseRace horseRace) throws SQLException;

    List<HorseRace> getAll() throws SQLException;

    HorseRace getById(int Id) throws SQLException;

    //update
    void update(HorseRace horseRace) throws SQLException;

    //delete
    void remove(HorseRace horseRace) throws SQLException;
}
