package note.service.impl;

import note.dao.UserDao;
import note.dao.impl.UserDaoImpl;
import note.service.UserService;
import note.vo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean login(User user) throws Exception {
        return userDao.login(user);
    }

    @Override
    public void register(User user) throws Exception {
        userDao.register(user);
    }

    @Override
    public boolean checkUser(User user) throws Exception {
        return false;
    }

    @Override
    public String queryById(User user) throws Exception {
        return null;
    }

    @Override
    public List<User> queryAll() throws Exception {
        return userDao.queryAll();
    }

    @Override
    public void delete(int id) throws Exception {
        userDao.delete(id);
    }

    @Override
    public void update(String id) throws Exception {

    }

    @Override
    public void update(User user) throws Exception {

    }
}
