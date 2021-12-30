package org.youcode.foracademy.interfaceImp;

import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Adress;
import org.youcode.foracademy.models.Fabrique;
import org.youcode.foracademy.models.Role;
import org.youcode.foracademy.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IntDAO<User> {

    /* CREATE */
    @Override
    public User create(User user) {
        try (PreparedStatement prepare = this.connect.prepareStatement(
                "INSERT INTO users (first_name," +
                        "last_name," +
                        "email," +
                        "password," +
                        "phone," +
                        "gander," +
                        "status_compte) " +
                        "VALUES(?,?,?,?,?,?,?)");
        ) {
            prepare.setString(1, user.getFirst_name());
            prepare.setString(2, user.getLast_name());
            prepare.setString(3, user.getEmail());
            prepare.setString(4, user.getPassword());
            prepare.setLong(5, user.getPhone());
            prepare.setString(6, user.getGander());
            prepare.setBoolean(7, user.isStatus_compte());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    /* READ ALL*/
    @Override
    public List readAll() {
        List users = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM users");
        ) {
            users = new ArrayList();
            while (result.next()) {
                User user = new User(
/*
                        result.getLong("id_user"),
*/
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getLong("phone"),
                        result.getString("gander"),
                        result.getBoolean("status_compte"),
                        (Role)result.getObject("id_role"),
                        (Adress)result.getObject("id_adress"),
                        (Fabrique)result.getObject("id_fabrique")
                );
                users.add(user);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return users;
    }

    /* READ BY ID*/
    @Override
    public User read(long id) {
        User user = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM users WHERE id_user = " + id);
        ) {
            if (result.next()) {
                user = new User(id,
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getLong("phone"),
                        result.getString("gander"),
                        result.getBoolean("status_compte"),
                        (Role)result.getObject("id_role"),
                        (Adress)result.getObject("id_adress"),
                        (Fabrique)result.getObject("id_fabrique"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }






    /* UPDATE */

    @Override
    public User update(User user) {
        try (
                PreparedStatement userStatement = this.connect.prepareStatement(
                        "UPDATE users set " +
                                "first_name = ? ," +
                                "last_name = ?," +
                                "email = ? , " +
                                "phone = ? , " +
                                "gander = ? , " +
                                "status_compte = ? " +
                                "WHERE id_user = ? ");
        ) {

            userStatement.setString(1, user.getFirst_name());
            userStatement.setString(2, user.getLast_name());
            userStatement.setString(3, user.getEmail());
            userStatement.setLong(4, user.getPhone());
            userStatement.setString(5, user.getGander());
            userStatement.setBoolean(6, user.isStatus_compte());
            userStatement.setLong(7, user.getId_user());

            userStatement.executeUpdate();

            user = this.read(user.getId_user());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    /* DELETE */
    @Override
    public User delete(User user) {
        try(
                PreparedStatement userStatement = this.connect.prepareStatement(
                        "UPDATE users SET " +
                                "status_compte = ? "+
                        "WHERE id_user = ? ");
        ) {
            userStatement.setBoolean(1, false);
            userStatement.setLong(2, user.getId_user());
            userStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(user.getId_user() + "non desactiver");

        }

        System.out.println("L'utilisateur " + user.getId_user() + " a été desactiver avec succèes.");
        return user;
    }

}
