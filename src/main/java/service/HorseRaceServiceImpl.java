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
    public void add(HorseRace horseRace) throws SQLException {
        horseRaceDao.add(horseRace);

    }

    @Override
    public List<HorseRace> getAll() throws SQLException {
        return horseRaceDao.getAll();
    }

    @Override
    public HorseRace getById(int Id) throws SQLException {
        return horseRaceDao.getById(Id);
    }

    @Override
    public void update(HorseRace horseRace) throws SQLException {
        horseRaceDao.update(horseRace);
    }

    @Override
    public void remove(HorseRace horseRace) throws SQLException {
        horseRaceDao.remove(horseRace);

    }
}
