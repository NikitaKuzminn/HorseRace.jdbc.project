package service;

import dao.GameFundDao;
import dao.GameFundDaoImpl;
import entity.GameFund;

import java.sql.SQLException;
import java.util.List;

public class GameFundServiceImpl implements GameFundService {
    GameFundDao gameFundDao = new GameFundDaoImpl();

    @Override
    public void add(GameFund gameFund) throws SQLException {
        gameFundDao.add(gameFund);
    }

    @Override
    public List<GameFund> getAll() throws SQLException {
        return gameFundDao.getAll();
    }

    @Override
    public GameFund getById(int id) throws SQLException {
        return gameFundDao.getById(id);
    }

    @Override
    public int getSum() throws SQLException {
        return gameFundDao.getSum();
    }

    @Override
    public void update(GameFund gameFund) throws SQLException {
        gameFundDao.update(gameFund);
    }

    @Override
    public void remove(GameFund gameFund) throws SQLException {
        gameFundDao.remove(gameFund);
    }
}
