package org.youcode.foracademy.interfaceImp;

import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Event;
import org.youcode.foracademy.models.User;
import org.youcode.foracademy.util.Utils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDao implements IntDAO<Event> {

    /* CREATE */
    @Override
    public Event create(Event event) {
        try (PreparedStatement prepare = this.connect.prepareStatement(
                "INSERT INTO event (" +
                        "start_date," +
                        "end_date," +
                        "name_event," +
                        "status_event " +
                        "VALUES(?,?,?,?)");
        ) {
            prepare.setDate(1, Utils.getSqlDate(event.getStart_date()));
            prepare.setDate(2, Utils.getSqlDate(event.getEnd_date()));
            prepare.setString(3, event.getName_event());
            prepare.setBoolean(4, event.getStatus_event());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }


    /* READ ALL*/
    @Override
    public List readAll() {
        List events = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM event");
        ) {
            events = new ArrayList();
            while (result.next()) {
                Event event = new Event(
                        result.getInt("id_event"),
                        result.getString("name_event"),
                        result.getDate("start_date"),
                        result.getDate("end_date"),
                        result.getBoolean("status_event")

                );
                events.add(event);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return events;
    }

    /* READ BY ID*/
    @Override
    public Event read(long id) {
        Event event = null;
        try (
                ResultSet result = this.connect.createStatement().executeQuery(
                        "SELECT * FROM event WHERE id_event = " + id);
        ) {
            if (result.next()) {
                event = new Event(
                        result.getInt("id_event"),
                        result.getString("name_event"),
                        result.getDate("start_date"),
                        result.getDate("end_date"),
                        result.getBoolean("status_event")
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }






    /* UPDATE */

    @Override
    public Event update(Event event) {
        try (
                PreparedStatement prepare = this.connect.prepareStatement(
                        "UPDATE event set " +

                                "start_date," +
                                "end_date," +
                                "name_event," +
                                "status_event " +
                                "WHERE id_event = ? ");
        ) {

            prepare.setDate(1, Utils.getSqlDate(event.getStart_date()));
            prepare.setDate(2, Utils.getSqlDate(event.getEnd_date()));
            prepare.setString(3, event.getName_event());
            prepare.setBoolean(4, event.getStatus_event());

            prepare.executeUpdate();

            event = this.read(event.getId_event());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }


    /* DELETE */
    @Override
    public Event delete(Event event) {
        try (
                PreparedStatement eventStatement = this.connect.prepareStatement(
                        "UPDATE event SET " +
                                "status_event = ? " +
                                "WHERE id_event = ? ");
        ) {
            eventStatement.setBoolean(1, false);
            eventStatement.setLong(2, event.getId_event());
            eventStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(event.getId_event() + "non desactiver");

        }

        System.out.println("L'event " + event.getId_event() + " a été desactiver avec succèes.");
        return event;
    }

}
