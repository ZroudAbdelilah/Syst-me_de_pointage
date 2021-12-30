package org.youcode.foracademy.interfaceImp;

import org.youcode.foracademy.interfaces.IntDAO;
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
                "INSERT INTO users (first_name,last_name,email,password,phone,gander,status_compte) " +
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
                        result.getLong("id_user"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getLong("phone"),
                        result.getString("gander"),
                        result.getBoolean("status_compte"),
                        result.getLong("id_role"),
                        result.getLong("id_adress"),
                        result.getLong("id_fabrique")
                );
                users.add(user);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return roles;
    }

    /* READ BY ID*/
    @Override
    public Role read(long id) {
        Role role = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM roles WHERE id_role = " + id);
        ) {
            if (result.next()) {
                role = new Role(id,
                        result.getString("name_role"),
                        result.getString("description_role"),
                        result.getBoolean("status_role"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }






    /* UPDATE */

    @Override
    public Role update(Role role) {
        try (
                PreparedStatement roleStatement = this.connect.prepareStatement(
                        "UPDATE roles set " +
                                "name_role = ? ," +
                                "description_role = ?," +
                                "status_role = ? " +
                                "WHERE id_role = ? ");
        ) {

            roleStatement.setString(1, role.getName_role());
            roleStatement.setString(2, role.getDescription_role());
            roleStatement.setBoolean(3, role.getStatus_role());
            roleStatement.setLong(4, role.getId_role());

            roleStatement.executeUpdate();

            role = this.read(role.getId_role());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }


    /* DELETE */
    @Override
    public void delete(Role role) {
        try(
                PreparedStatement roleStatement = this.connect.prepareStatement(
                        "DELETE FROM roles " +
                                "WHERE id_role = ?");
        ) {
            roleStatement.setLong(1, role.getId_role());
            roleStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(role.getId_role() + "non desactiver");

        }

        System.out.println("Le role " + role.getId_role() + " a été desactiver avec succèes.");
    }

}
