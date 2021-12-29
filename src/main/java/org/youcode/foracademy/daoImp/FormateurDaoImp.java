package org.youcode.foracademy.daoImp;


import org.youcode.foracademy.interfaceImp.FormateurDao;
import org.youcode.foracademy.models.*;
import org.youcode.foracademy.util.DbConnection;
import org.youcode.foracademy.models.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FormateurDaoImp implements FormateurDao {
    @Override
    public boolean delete(long id_user){
        Connection con = DbConnection.getConnection();
        if (con == null){
            return false;
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
        return true;
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
                Role role = (Role)resultSet.getObject("Role");
                Adress adress = (Adress) resultSet.getObject("Adress");
                Fabrique fabrique = (Fabrique) resultSet.getObject("Fabrique");
                Class aclass = (Class) resultSet.getObject("Class");
                Specialiter specialiter = (Specialiter) resultSet.getObject("Specialiter");
                Formateur formateur = new Formateur(resultSet.getLong("id_user"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getLong("phone"),resultSet.getString("gander"),resultSet.getBoolean("status_compte"),role,adress,fabrique,aclass,specialiter);

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
                Role role = (Role)resultSet.getObject("Role");
                Adress adress = (Adress) resultSet.getObject("Adress");
                Fabrique fabrique = (Fabrique) resultSet.getObject("Fabrique");
                Specialiter specialiter = (Specialiter) resultSet.getObject("Specialiter");
                Class aclass = (Class) resultSet.getObject("Class");

                Formateur formateur= new Formateur(resultSet.getLong("id_user"),resultSet.getString("first_name"),
                        resultSet.getString("last_name"),resultSet.getString("email"),resultSet.getString("password"),
                        resultSet.getLong("phone"),resultSet.getString("gander"),resultSet.getBoolean("status_compte"),
                        role,adress,fabrique,aclass,specialiter);
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
    public Formateur insert(Formateur formateur){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return null ;
        }else if (formateur.getId_user() == 0){
            String query =" INSERT INTO formateur (first_name,last_name,email,password,phone,gander,status_compte,id_role,id_adress,id_fabrique,id_class,id_specialiter VALUES (?,?,?,?,?,?,?,?,?,?,?,?)) ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, formateur.getFirst_name());
                preparedStatement.setString(2, formateur.getLast_name());
                preparedStatement.setString(3, formateur.getEmail());
                preparedStatement.setString(4, formateur.getPassword());
                preparedStatement.setLong(5,formateur.getPhone());
                preparedStatement.setString(6,formateur.getGander());
                preparedStatement.setBoolean(7,formateur.isStatus_compte());
                preparedStatement.setLong(8, formateur.getRole().getId_role());
                preparedStatement.setLong(9,formateur.getAdress().getId_adress());
                preparedStatement.setLong(10,formateur.getFabrique().getId_fabrique());
                preparedStatement.setLong(11,formateur.getAclass().getId_class());
                preparedStatement.setLong(12,formateur.getSpecialiter().getId_specialiter());
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
        return formateur;

    }
    @Override
    public Formateur update(Formateur formateur){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return null;
        }else if (formateur.getId_user()!=0){
            String query =" UPDATE  formateur SET first_name = ?,last_name = ?,email = ?,password = ?,phone = ?,gander = ?,status_compte = ?,id_role = ?,id_adress = ? ,id_event = ? ,id_fabrique = ? ,id_class = ?,id_specialiter = ? WHERE id_user = ? ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, formateur.getFirst_name());
                preparedStatement.setString(2, formateur.getLast_name());
                preparedStatement.setString(3, formateur.getEmail());
                preparedStatement.setString(4, formateur.getPassword());
                preparedStatement.setLong(5,formateur.getPhone());
                preparedStatement.setString(6,formateur.getGander());
                preparedStatement.setBoolean(7,formateur.isStatus_compte());
                preparedStatement.setLong(8, formateur.getRole().getId_role());
                preparedStatement.setLong(9,formateur.getAdress().getId_adress());
                preparedStatement.setLong(11,formateur.getFabrique().getId_fabrique());
                preparedStatement.setLong(12,formateur.getAclass().getId_class());
                preparedStatement.setLong(13,formateur.getSpecialiter().getId_specialiter());
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
        return formateur;
    }
}
