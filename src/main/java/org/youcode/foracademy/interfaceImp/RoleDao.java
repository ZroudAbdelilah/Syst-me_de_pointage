package org.youcode.foracademy.interfaceImp;

import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Role;
import org.youcode.foracademy.models.User;
import org.youcode.foracademy.util.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RoleDao implements IntDAO<Role> {

    /* CREATE */
    @Override
    public Role create(Role role) {
        try (PreparedStatement prepare = this.connect.prepareStatement(
                "INSERT INTO roles (name_role,description_role,status_role) VALUES(?,?,?)");
        ) {
            prepare.setString(1, role.getName_role());
            prepare.setString(2, role.getDescription_role());
            prepare.setBoolean(3, role.getStatus_role());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }


    /* READ ALL*/
    @Override
    public List readAll() {
        List roles = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM roles");
        ) {
            roles = new ArrayList();
            while (result.next()) {
                Role role = new Role(
                        result.getLong("id_role"),
                        result.getString("name_role"),
                        result.getString("description_role"),
                        result.getBoolean("status_role")
                );
                roles.add(role);

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
    public Role delete(Role role) {
        try (
                PreparedStatement roleStatement = this.connect.prepareStatement(
                        "UPDATE roles SET " +
                                "status_role = ? " +
                                "WHERE id_role = ? ");
        ) {
            roleStatement.setBoolean(1, false);
            roleStatement.setLong(2, role.getId_role());
            roleStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(role.getId_role() + " non desactiver");

        }

        System.out.println("Le role " + role.getId_role() + " a été desactiver avec succèes." );
        return role;
    }
}
