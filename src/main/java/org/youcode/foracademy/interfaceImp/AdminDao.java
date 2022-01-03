package org.youcode.foracademy.interfaceImp;

import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Adress;
import org.youcode.foracademy.models.Fabrique;
import org.youcode.foracademy.models.Role;
import org.youcode.foracademy.models.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao implements IntDAO<Admin> {

    /* CREATE */
    @Override
    public Admin create(Admin admin) {
        try (PreparedStatement prepare = this.connect.prepareStatement(
                "INSERT INTO admins (first_name," +
                        "last_name," +
                        "email," +
                        "password," +
                        "phone," +
                        "gander," +
                        "status_compte) " +
                        "VALUES(?,?,?,?,?,?,?)");
        ) {
            prepare.setString(1, admin.getFirst_name());
            prepare.setString(2, admin.getLast_name());
            prepare.setString(3, admin.getEmail());
            prepare.setString(4, admin.getPassword());
            prepare.setString(5, admin.getPhone());
            prepare.setString(6, admin.getGender());
            prepare.setBoolean(7, admin.isStatus_compte());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }


    /* READ ALL*/
    @Override
    public List readAll() {
        List admins = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM admins");
        ) {
            admins = new ArrayList();
            while (result.next()) {
                Admin admin = new Admin(
/*
                        result.getLong("id_admin"),
*/
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("phone"),
                        result.getString("gander"),
                        result.getBoolean("status_compte"),
                        (Role)result.getObject("id_role"),
                        (Adress)result.getObject("id_adress"),
                        (Fabrique)result.getObject("id_fabrique")
                );
                admins.add(admin);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return admins;
    }

    /* READ BY ID*/
    @Override
    public Admin read(long id) {
        Admin admin = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM admins WHERE id_admin = " + id);
        ) {
            if (result.next()) {
                admin = new Admin(id,
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("phone"),
                        result.getString("gander"),
                        result.getBoolean("status_compte"),
                        (Role)result.getObject("id_role"),
                        (Adress)result.getObject("id_adress"),
                        (Fabrique)result.getObject("id_fabrique"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }






    /* UPDATE */

    @Override
    public Admin update(Admin admin) {
        try (
                PreparedStatement adminStatement = this.connect.prepareStatement(
                        "UPDATE admins set " +
                                "first_name = ? ," +
                                "last_name = ?," +
                                "email = ? , " +
                                "phone = ? , " +
                                "gander = ? , " +
                                "status_compte = ? " +
                                "WHERE id_admin = ? ");
        ) {

            adminStatement.setString(1, admin.getFirst_name());
            adminStatement.setString(2, admin.getLast_name());
            adminStatement.setString(3, admin.getEmail());
            adminStatement.setString(4, admin.getPhone());
            adminStatement.setString(5, admin.getGender());
            adminStatement.setBoolean(6, admin.isStatus_compte());
            adminStatement.setLong(7, admin.getId_admin());

            adminStatement.executeUpdate();

            admin = this.read(admin.getId_admin());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }


    /* DELETE */
    @Override
    public Admin delete(Admin admin) {
        try(
                PreparedStatement adminStatement = this.connect.prepareStatement(
                        "UPDATE admins SET " +
                                "status_compte = ? "+
                                "WHERE id_admin = ? ");
        ) {
            adminStatement.setBoolean(1, false);
            adminStatement.setLong(2, admin.getId_admin());
            adminStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(admin.getId_admin() + "non desactiver");

        }

        System.out.println("L'utilisateur " + admin.getId_admin() + " a été desactiver avec succèes.");
        return admin;
    }

}
