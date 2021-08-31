package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.Bet;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();

    @Override
    public void add(User user) throws SQLException {
        userDao.add(user);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return userDao.getAll();
    }

    @Override
    public User getById(int Id) throws SQLException {
        return userDao.getById(Id);
    }

    @Override
    public void update(User user) throws SQLException {
        userDao.update(user);

    }

    @Override
    public void updateCash(int id, int cash) throws SQLException {
        userDao.updateCash(id, cash);
    }


    @Override
    public void removeById(int id) throws SQLException {
        userDao.removeById(id);
    }
}
