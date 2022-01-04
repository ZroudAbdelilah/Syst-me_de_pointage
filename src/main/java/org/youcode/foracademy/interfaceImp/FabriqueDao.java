package org.youcode.foracademy.interfaceImp;

import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Adress;
import org.youcode.foracademy.models.Fabrique;
import org.youcode.foracademy.models.Pointeur;
import org.youcode.foracademy.models.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FabriqueDao implements IntDAO<Fabrique>{

    /* CREATE */
    @Override
    public Fabrique create(Fabrique fabrique) {
        try (PreparedStatement prepare = this.connect.prepareStatement(
                "INSERT INTO fabrique (" +
                        "name_fabrique," +
                        "status_fabrique) " +
                        "VALUES(?,?)");
        ) {
            prepare.setString(1, fabrique.getName_fabrique());
            prepare.setBoolean(2, fabrique.getStatus_fabrique());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fabrique;
    }


    /* READ ALL*/
    @Override
    public List readAll() {
        List fabriques = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM fabrique");
        ) {
            fabriques = new ArrayList();
            while (result.next()) {
                Fabrique fabrique = new Fabrique(
                        result.getLong("id_fabrique"),
                        result.getString("name_fabrique"),
                        (Pointeur)result.getObject("id_pointeur"),
                        (Adress)result.getObject("id_adress"),
                        result.getBoolean("status_fabrique")

                );
                fabriques.add(fabrique);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return fabriques;
    }

    /* READ BY ID*/
    @Override
    public Fabrique read(long id) {
        Fabrique fabrique = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM fabrique WHERE id_fabrique = " + id);
        ) {
            if (result.next()) {
                fabrique = new Fabrique(
                        result.getLong("id_fabrique"),
                        result.getString("name_fabrique"),
                        (Pointeur)result.getObject("id_pointeur"),
                        (Adress)result.getObject("id_adress"),
                        result.getBoolean("status_fabrique"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fabrique;
    }






    /* UPDATE */

    @Override
    public Fabrique update(Fabrique fabrique) {
        try (
                PreparedStatement prepare = this.connect.prepareStatement(
                        "UPDATE fabrique set " +

                                "name_fabrique," +
                                "status_fabrique " +
                                "WHERE id_fabrique = ? ");
        ) {

            prepare.setString(1, fabrique.getName_fabrique());
            prepare.setBoolean(2, fabrique.getStatus_fabrique());
            prepare.executeUpdate();

            fabrique = this.read(fabrique.getId_fabrique());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fabrique;
    }


    /* DELETE */
    @Override
    public Fabrique delete(Fabrique fabrique) {
        try (
                PreparedStatement fabriqueStatement = this.connect.prepareStatement(
                        "UPDATE fabrique SET " +
                                "status_fabrique = ? " +
                                "WHERE id_fabrique = ? ");
        ) {
            fabriqueStatement.setBoolean(1, false);
            fabriqueStatement.setLong(2, fabrique.getId_fabrique());
            fabriqueStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(fabrique.getId_fabrique() + "non desactiver");

        }

        System.out.println("La Fabrique " + fabrique.getId_fabrique() + " a été desactiver avec succèes.");
        return fabrique;
    }

}
