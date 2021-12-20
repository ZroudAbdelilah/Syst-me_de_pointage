package org.youcode.foracademy.dao.formateurDao;

import org.youcode.foracademy.models.Formateur;
import org.youcode.foracademy.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FormateurDaoImp implements FormateurDao {
    @Override
    public long delete(long id_user){
        Connection con = DbConnection.getConnection();
        if (con == null){
            return 0;
        }
        String query ="DELETE FROM formateur WHERE id_user = ? ";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setLong(1,id_user);
            preparedStatement.executeUpdate();

        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                con.close();

            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return 0;
    }
    @Override
    public List<Formateur> findAll(){
        Connection con =DbConnection.getConnection();
        if (con == null){
            return null;
        }
        List<Formateur> formateurs =new LinkedList<>();
        String query ="SELECT * FROM formateur";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Formateur formateur =new Formateur(resultSet.getLong("id_user"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getLong("phone"),resultSet.getString("gander"),resultSet.getBoolean("status_compte"),resultSet.getObject("Role"),resultSet.getObject("id_adress"),resultSet.getObject("id_event"),resultSet.getObject("id_fabrique"),resultSet.getObject("id_specialiter"));
                formateurs.add(formateur);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return formateurs;
    }
    @Override
    public Formateur findById(long id_user){
        Connection con = DbConnection.getConnection();
        if (con == null){
        return null;
        }
        String query =" SELECT  FROM formateur WHERE id_user = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setLong(1,id_user);
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){
                Formateur formateur= new Formateur(resultSet.getLong("id_user"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getLong("phone"),resultSet.getString("gander"),resultSet.getBoolean("status_compte"),resultSet.getObject("Role"),resultSet.getObject("id_adress"),resultSet.getObject("id_event"),resultSet.getObject("id_fabrique"),resultSet.getObject("id_specialiter"));
                return formateur;
            }

        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public void insert(Formateur formateur){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return ;
        }else{
            String query =" INSERT INTO formateur (first_name,last_name,email,password,phone,gander,status_compte,id_role,id_adress,id_event,id_fabrique,id_class,id_specialiter VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, formateur.getFirst_name());
                preparedStatement.setString(2, formateur.getLast_name());
                preparedStatement.setString(3, formateur.getEmail());
                preparedStatement.setString(4, formateur.getPassword());
                preparedStatement.setLong(5,formateur.getPhone());
                preparedStatement.setString(6,formateur.getGander());
                preparedStatement.setBoolean(7,formateur.isStatus_compte());
                preparedStatement.setObject(8, formateur.getRole());
                preparedStatement.setObject(9,formateur.getAdress());
                preparedStatement.setObject(10,formateur.getEvent());
                preparedStatement.setObject(11,formateur.getFabrique());
                preparedStatement.setObject(12,formateur.getClass());
                preparedStatement.setObject(13,formateur.getSpecialiter());
                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }
    @Override
    public void update(Formateur formateur){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return ;
        }else if (formateur.getId_user()!=0){
            String query =" UPDATE  formateur SET (first_name = ?,last_name = ?,email = ?,password = ?,phone = ?,gander = ?,status_compte = ?,id_role = ?,id_adress = ? ,id_event = ? ,id_fabrique = ? ,id_class = ?,id_specialiter = ? WHERE id = ?s ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, formateur.getFirst_name());
                preparedStatement.setString(2, formateur.getLast_name());
                preparedStatement.setString(3, formateur.getEmail());
                preparedStatement.setString(4, formateur.getPassword());
                preparedStatement.setLong(5,formateur.getPhone());
                preparedStatement.setString(6,formateur.getGander());
                preparedStatement.setBoolean(7,formateur.isStatus_compte());
                preparedStatement.setObject(8, formateur.getRole());
                preparedStatement.setObject(9,formateur.getAdress());
                preparedStatement.setObject(10,formateur.getEvent());
                preparedStatement.setObject(11,formateur.getFabrique());
                preparedStatement.setObject(12,formateur.getClass());
                preparedStatement.setObject(13,formateur.getSpecialiter());
                preparedStatement.setLong(14,formateur.getId_user());
                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
