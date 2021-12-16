import jdbc.Models.User;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class UserDao {
    private String url;
    private String username;
    private String password;

    public UserDao(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void addUser(User user) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            if (user.getId() != null) {
                PreparedStatement statement = connection.prepareStatement
                        (sql:"update user set name = ? where id = ?;");
                statement.setString(parameterIndex:1, user.getName());
                statement.setLong(parameterIndex:2, user.getId(););
                statement.execute();
            } else {
                PreparedStatement statement = connection.prepareStatement
                        (sql:"insert into user (name) values (?);");
                statement.setString(parameterIndex:1, user.getName());
                statement.execute();
            }
            System.out.println(user.getName()"saved successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(user.getName()"unsaved");

        }
    }
}