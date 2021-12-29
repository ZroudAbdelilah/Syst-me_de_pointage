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





    /* READ */
    @Override
    public Role read(long id_role) {
        Role role= null;
        try {
            ResultSet result = this .connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeQuery(
                    "SELECT * FROM roles" + id_role);
            if(result.first())
                role = new Role(
                        id_role,
/*
                        result.getLong("id_role"),
*/
                        result.getString("name_role"),
                        result.getString("description_role"),
                        result.getBoolean("status_role")
                );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }






    /* UPDATE */

    @Override
    public Role update(Role role) {
        try {

            PreparedStatement roleStatement = this.connect.prepareStatement(
                    "UPDATE role set name_role = ? ," +
                            "description_role = ?," +
                            "status_role = ?," +
                            " WHERE id_role = ?");

            roleStatement.setString(1, role.getName_role());
            roleStatement.setString(2, role.getDescription_role());
            roleStatement.setBoolean(3, role.getStatus_role());
            role = this.read(role.getId_role());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }








    /* DELETE */
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
