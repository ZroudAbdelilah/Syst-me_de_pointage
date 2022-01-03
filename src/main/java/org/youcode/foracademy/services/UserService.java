package org.youcode.foracademy.services;

import org.youcode.foracademy.interfaceImp.UserDao;
import org.youcode.foracademy.models.User;
import java.util.List;

//Go to the class and click alt + enter to generate jUnite tests boilerplate
public class UserService {

    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User read(long id) {
        return userDao.read(id);
    }

    public List<User> readAll() {
        return userDao.readAll();
    }

    public User delete(User user) {
        return userDao.delete(user);
    }

    public User create(User user) {
        return userDao.create(user);
    }

    public User update(User user) {
        return userDao.update(user);
    }
}


