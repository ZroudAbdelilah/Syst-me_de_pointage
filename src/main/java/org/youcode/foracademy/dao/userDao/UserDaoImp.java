

package org.youcode.foracademy.dao.userDao;

import org.youcode.foracademy.dao.DAOException.DAOException;
import org.youcode.foracademy.models.User;
import org.youcode.foracademy.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {
    @Override
    public void addUser(User user) throws DAOException {
        try {
            Connection connection = DbConnection.getConnection();
            if (Long.valueOf(user.getId_user()) != null) {
                PreparedStatement statement = connection.prepareStatement
                        ("update users set first_name = ? where id_user = ?;");
                statement.setString(1, user.getFirst_name());
                statement.setLong(2, user.getId_user());
                statement.execute();
            } else {
                PreparedStatement statement = connection.prepareStatement
                        ("insert into users (first_name) values (?);");
                statement.setString(1, user.getFirst_name());
                statement.execute();
            }
            System.out.println(user.getFirst_name() + " saved successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(user.getFirst_name() + "unsaved");

        }
    }
}

