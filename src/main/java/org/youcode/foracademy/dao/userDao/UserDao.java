package org.youcode.foracademy.dao.userDao;

import org.youcode.foracademy.dao.DAOException.DAOException;
import org.youcode.foracademy.models.User;

public interface UserDao {
    void addUser (User user ) throws DAOException;

}
