package org.youcode.foracademy.interfaceImp;

import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Role;

import org.youcode.foracademy.dao.DAOException.DAOException;
import org.youcode.foracademy.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RoleDao implements IntDAO<Role>  {

    /* CREATE */
    @Override
    public Role create(Role role) {
        try{
            PreparedStatement prepare = this.connect.prepareStatement(
                    "INSERT INTO roles (id_role,name_role,description_role,status_role) VALUES(?,?,?,?)");
            prepare.setLong(1, role.getId_role());
            prepare.setString(2, role.getName_role());
            prepare.setString(3, role.getDescription_role());
            prepare.setBoolean(4, role.getStatus_role());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public Role read(long id) {
        return null;
    }

    @Override
    public Role update(Role obj) {
        return null;
    }

    @Override
    public void delete(Role role) {
        try {
            Connection connection = DbConnection.getConnection();
            if (role.getId_role() != 0) {
                PreparedStatement statement = connection.prepareStatement("update roles set status_role = ? where id_role = ?;");
                statement.setBoolean(1, false);
                statement.setLong(2, role.getId_role());
                statement.execute();
            }

            System.out.println("Le role " + role.getId_role() + " a été desactiver avec succèes.");
        } catch (SQLException var4) {
            var4.printStackTrace();
            System.out.println(role.getId_role() + "non desactiver");
        }
    }
}
