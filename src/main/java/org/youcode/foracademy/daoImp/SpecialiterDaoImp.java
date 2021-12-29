package org.youcode.foracademy.daoImp;

import org.youcode.foracademy.interfaceImp.SpecialiterDao;
import org.youcode.foracademy.models.*;
import org.youcode.foracademy.util.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SpecialiterDaoImp implements SpecialiterDao {
    @Override
    public boolean delete(long id_specialiter){
        Connection con = DbConnection.getConnection();
        if (con == null){
            return false;
        }
        String query ="DELETE FROM specialiter WHERE id_specialiter = ? ";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setLong(1,id_specialiter);
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
    public List<Specialiter> findAll(){
        Connection con =DbConnection.getConnection();
        if (con == null){
            return null;
        }
        List<Specialiter> specialiters =new LinkedList<>();
       String  query = "SELECT * FROM specialiter";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                Specialiter specialiter = new Specialiter(resultSet.getLong("id_specialiter"),resultSet.getString("name_specialiter"),resultSet.getString("description"));

                specialiters.add(specialiter);
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
        return specialiters;
    }
    @Override
    public Specialiter findById(long id_specialiter){
        Connection con = DbConnection.getConnection();
        if (con == null){
            return null;
        }
        String query =" SELECT * FROM specialiter WHERE id_specialiter = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setLong(1,id_specialiter);
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){

                Specialiter specialiter = new Specialiter(resultSet.getLong("id_specialiter"),resultSet.getString("name_specialiter"),
                        resultSet.getString("description"));
                return specialiter;
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
    public Specialiter insert(Specialiter specialiter){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return null ;
        }else if (specialiter.getId_specialiter() == 0) {
          String query =" INSERT INTO specialiter (name_specialiter, description) VALUES (?,?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, specialiter.getName_specialiter());
                preparedStatement.setString(2, specialiter.getDescription());

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
        return specialiter;

    }
    @Override
    public Specialiter update(Specialiter specialiter){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return null;
        }else if (specialiter.getId_specialiter() > 0){

            String query = " UPDATE  specialiter  SET name_specialiter = ?,description = ? WHERE id_specialiter = ? ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, specialiter.getName_specialiter());
                preparedStatement.setString(2, specialiter.getDescription());
                preparedStatement.setLong(3,specialiter.getId_specialiter());
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
        return specialiter;
    }
}
