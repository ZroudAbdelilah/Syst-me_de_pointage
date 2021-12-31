package org.youcode.foracademy.interfaceImp;

import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Pointer;
import org.youcode.foracademy.models.Pointeur;
import org.youcode.foracademy.models.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PointerDao implements IntDAO<Pointer> {

    /* CREATE */
    @Override
    public Pointer create(Pointer pointer) {
        try (PreparedStatement prepare = this.connect.prepareStatement(
                "INSERT INTO pointer (" +
                        "arrival_date," +
                        "go_date " +
                        "VALUES(?,?)");
        ) {
            prepare.setDate(1, (Date) pointer.getArrival_date());
            prepare.setDate(2, (Date) pointer.getDo_date());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pointer;
    }


    /* READ ALL*/
    @Override
    public List readAll() {
        List pointers = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM pointer");
        ) {
            pointers = new ArrayList();
            while (result.next()) {
                Pointer pointer = new Pointer(
                        result.getLong("id_pointer"),
                        (User) result.getObject("id_user"),
                        (Pointeur) result.getObject("id_pointeur"),
                        result.getDate("arrival_date"),
                        result.getDate("go_date")

                );
                pointers.add(pointer);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return pointers;
    }

    /* READ BY ID*/
    @Override
    public Pointer read(long id) {
        Pointer pointer = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM pointer WHERE id_pointer = " + id);
        ) {
            if (result.next()) {
                pointer = new Pointer(
                        result.getLong("id_pointer"),
                        (User) result.getObject("id_user"),
                        (Pointeur) result.getObject("id_pointeur"),
                        result.getDate("arrival_date"),
                        result.getDate("go_date")
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pointer;
    }






    /* UPDATE */

    @Override
    public Pointer update(Pointer pointer) {
        try (
                PreparedStatement prepare = this.connect.prepareStatement(
                        "UPDATE pointer set " +

                                "arrival_date," +
                                "go_date " +
                                "WHERE id_pointer = ? ");
        ) {

            prepare.setDate(1, (Date) pointer.getArrival_date());
            prepare.setDate(2, (Date) pointer.getDo_date());
            prepare.executeUpdate();

            pointer = this.read(pointer.getId_pointer());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pointer;
    }


    /* DELETE */
    @Override
    public Pointer delete(Pointer pointer) {
        return null;
    }

}
