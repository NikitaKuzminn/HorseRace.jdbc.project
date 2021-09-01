package service;

import dao.HorseDao;
import dao.HorseRaceDao;
import dao.HorseRaceDaoImpl;
import entity.HorseRace;

import java.sql.SQLException;
import java.util.List;

public class HorseRaceServiceImpl implements HorseRaceService {
    HorseRaceDao horseRaceDao = new HorseRaceDaoImpl();

    @Override
    public void add(HorseRace horseRace) {
        try {
            horseRaceDao.add(horseRace);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HorseRace> getAll() {
        List<HorseRace> horseRaces = null;
        try {
            horseRaces = horseRaceDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horseRaces;
    }

    @Override
    public HorseRace getById(int Id) {
        HorseRace horseRace = null;
        try {
            horseRace = horseRaceDao.getById(Id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horseRace;
    }

    @Override
    public void update(HorseRace horseRace) {
        try {
            horseRaceDao.update(horseRace);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(HorseRace horseRace) {
        try {
            horseRaceDao.remove(horseRace);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
