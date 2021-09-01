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
    public void add(User user) {
        try {
            userDao.add(user);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = null;
        try {
            users = userDao.getAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(int Id) {
        User user = null;
       try {
           user = userDao.getById(Id);
       }catch (SQLException e){
           e.printStackTrace();
       }
       return user;
    }

    @Override
    public void update(User user) {
        try {
            userDao.update(user);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateCash(int id, int cash) {
       try {
           userDao.updateCash(id, cash);
       }catch (SQLException e){
           e.printStackTrace();
       }
    }


    @Override
    public void removeById(int id) {
        try {
            userDao.removeById(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
