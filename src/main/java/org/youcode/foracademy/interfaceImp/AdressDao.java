package org.youcode.foracademy.interfaceImp;

import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Adress;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdressDao implements IntDAO<Adress> {

    /* CREATE */
    @Override
    public Adress create(Adress adress) {
        try (PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO adress (" + "country," + "region," + "city," + "code_postal, " + "status_adress) " + "VALUES(?,?,?,?,?)");) {
            prepare.setString(1, adress.getCountry());
            prepare.setString(2, adress.getRegion());
            prepare.setString(3, adress.getCity());
            prepare.setLong(4, adress.getCode_postal());
            prepare.setBoolean(5, adress.isStatus_adress());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adress;
    }


    /* READ ALL*/
    @Override
    public List readAll() {
        List adresses = null;
        try (ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM adress");) {
            adresses = new ArrayList();
            while (result.next()) {
                Adress adress = new Adress(result.getLong("id_adress"), result.getString("country"), result.getString("region"), result.getString("city"), result.getInt("code_postal"), result.getBoolean("status_adress"));
                adresses.add(adress);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return adresses;
    }

    /* READ BY ID*/
    @Override
    public Adress read(long id) {
        Adress adress = null;
        try (ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM adress WHERE id_adress = " + id);) {
            if (result.next()) {
                adress = new Adress(
                        id,
                        result.getString("country"),
                        result.getString("region"),
                        result.getString("city"),
                        result.getInt("code_postal"),
                        result.getBoolean("status_adress")
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adress;
    }






    /* UPDATE */

    @Override
    public Adress update(Adress adress) {
        try (PreparedStatement prepare = this.connect.prepareStatement("UPDATE adress set " + "country = ? ," + "region = ? ," + "city = ? ," + "code_postal = ?, " + "status_adress = ? " + "WHERE id_adress = ? ");) {

            prepare.setString(1, adress.getCountry());
            prepare.setString(2, adress.getRegion());
            prepare.setString(3, adress.getCity());
            prepare.setLong(4, adress.getCode_postal());
            prepare.setBoolean(5, adress.isStatus_adress());
            prepare.setLong(6, adress.getId_adress());
            prepare.executeUpdate();

            adress = this.read(adress.getId_adress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adress;
    }


    /* DELETE */
    @Override
    public Adress delete(Adress adress) {
        try (
                PreparedStatement Statement = this.connect.prepareStatement(
                "UPDATE adress SET " + "status_adress = ? " + "WHERE id_adress = ? ");) {
            Statement.setBoolean(1, false);
            Statement.setLong(2, adress.getId_adress());
            Statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(adress.getId_adress() + "non desactiver");

        }

        System.out.println("L'utilisateur " + adress.getId_adress() + " a été desactiver avec succèes.");
        return adress;
    }

}
