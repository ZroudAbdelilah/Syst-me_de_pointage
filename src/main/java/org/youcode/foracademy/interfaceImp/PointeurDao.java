package org.youcode.foracademy.interfaceImp;

import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Adress;
import org.youcode.foracademy.models.Fabrique;
import org.youcode.foracademy.models.Pointeur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PointeurDao implements IntDAO<Pointeur>{

    /* CREATE */
    @Override
    public Pointeur create(Pointeur pointeur) {
        try (PreparedStatement prepare = this.connect.prepareStatement(
                "INSERT INTO pointeur (" +
                        "brand," +
                        "status_pointeur " +
                        "VALUES(?,?)");
        ) {
            prepare.setString(1, pointeur.getBrand());
            prepare.setBoolean(2, pointeur.getStatus_pointeur());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pointeur;
    }


    /* READ ALL*/
    @Override
    public List readAll() {
        List pointeurs = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM pointeur");
        ) {
            pointeurs = new ArrayList();
            while (result.next()) {
                Pointeur pointeur = new Pointeur(
                        result.getLong("id_pointeur"),
                        result.getString("brand"),
                        result.getBoolean("status_fabrique")
                );
                pointeurs.add(pointeurs);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return pointeurs;
    }

    /* READ BY ID*/
    @Override
    public Pointeur read(long id) {
        Pointeur pointeur = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM pointeur WHERE id_ponteur = " + id);
        ) {
            if (result.next()) {
                pointeur = new Pointeur(
                        result.getLong("id_pointeur"),
                        result.getString("brand"),
                        result.getBoolean("status_pointeur"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pointeur;
    }






    /* UPDATE */

    @Override
    public Pointeur update(Pointeur pointeur) {
        try (
                PreparedStatement prepare = this.connect.prepareStatement(
                        "UPDATE pointeur set " +

                                "brand," +
                                "status_pointeur " +
                                "WHERE id_pointeur = ? ");
        ) {

            prepare.setString(1, pointeur.getBrand());
            prepare.setBoolean(2, pointeur.getStatus_pointeur());
            prepare.executeUpdate();

            pointeur = this.read(pointeur.getId_pointeur());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pointeur;
    }


    /* DELETE */
    @Override
    public Pointeur delete(Pointeur pointeur) {
        try (
                PreparedStatement userStatement = this.connect.prepareStatement(
                        "UPDATE pointeur SET " +
                                "status_pointeur = ? " +
                                "WHERE id_pointeur = ? ");
        ) {
            userStatement.setBoolean(1, false);
            userStatement.setLong(2, pointeur.getId_pointeur());
            userStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(pointeur.getId_pointeur() + "non desactiver");

        }

        System.out.println("Le Pointeur " + pointeur.getId_pointeur() + " a été desactiver avec succèes.");
        return pointeur;
    }

}
