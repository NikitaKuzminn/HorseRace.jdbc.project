package service;
import dao.HorseDao;
import dao.HorseDaoImpl;
import entity.Horse;

import java.sql.SQLException;
import java.util.List;

public class HorseServiceImpl implements HorseService {

    HorseDao horseDao = new HorseDaoImpl();


    @Override
    public void add(Horse horse) throws SQLException {
        horseDao.add(horse);
    }

    @Override
    public List<Horse> getAll() throws SQLException {
        return horseDao.getAll();
    }

    @Override
    public Horse getById(int Id) throws SQLException {
        return horseDao.getById(Id);
    }

    @Override
    public void update(Horse horse) throws SQLException {
        horseDao.update(horse);

    }

    @Override
    public void removeById(int id) throws SQLException {
        horseDao.removeById(id);

    }
}
