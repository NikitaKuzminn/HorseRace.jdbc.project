package service;

import dao.GameFundDao;
import dao.GameFundDaoImpl;
import entity.GameFund;

import java.sql.SQLException;
import java.util.List;

public class GameFundServiceImpl implements GameFundService {
    GameFundDao gameFundDao = new GameFundDaoImpl();

    @Override
    public void add(GameFund gameFund) {
        try {
            gameFundDao.add(gameFund);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GameFund> getAll() {
        List<GameFund> gameFundList = null;
        try {
            gameFundList = gameFundDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gameFundList;
    }

    @Override
    public GameFund getById(int id) {
        GameFund gameFund = null;
        try {
            gameFund = gameFundDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gameFund;
    }

    @Override
    public int getSum() {
        int sum = 0;
        try {
            sum = gameFundDao.getSum();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public void update(GameFund gameFund) {
        try {
            gameFundDao.update(gameFund);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(GameFund gameFund) {
        try {
            gameFundDao.remove(gameFund);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
