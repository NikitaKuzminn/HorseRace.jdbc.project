package service;

import dao.BetDao;
import dao.BetDaoImpl;
import entity.Bet;

import java.sql.SQLException;
import java.util.List;

public class BetServiceImpl implements BetService {

    private BetDao betDao = new BetDaoImpl();

    public BetServiceImpl() {
    }


    @Override
    public void add(Bet bet) throws SQLException {
        betDao.add(bet);
    }

    @Override
    public List<Bet> getAll() throws SQLException {
       return betDao.getAll();
    }

    @Override
    public Bet getById(int id) throws SQLException {
        return betDao.getById(id);
    }

    @Override
    public void update(Bet bet) throws SQLException {
        betDao.update(bet);

    }

    @Override
    public void remove(Bet bet) throws SQLException {
        betDao.remove(bet);
    }

    @Override
    public void removeById(int id) throws SQLException {
        betDao.removeById(id);
    }
}
