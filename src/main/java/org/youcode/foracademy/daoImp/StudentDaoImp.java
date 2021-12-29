package org.youcode.foracademy.daoImp;

import org.youcode.foracademy.interfaceImp.StudentDao;
import org.youcode.foracademy.models.*;
import org.youcode.foracademy.models.Class;
import org.youcode.foracademy.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentDaoImp implements StudentDao {
    @Override
    public boolean delete(long id_user){
        Connection con = DbConnection.getConnection();
        if (con == null){
            return false;
        }
        String query ="DELETE FROM student WHERE id_user = ? ";
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
    public List<Student> findAll(){
        Connection con =DbConnection.getConnection();
        if (con == null){
            return null;
        }
        List<Student> students =new LinkedList<>();
        String query ="SELECT * FROM student";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Role role = (Role)resultSet.getObject("Role");
                Adress adress = (Adress) resultSet.getObject("Adress");
                Fabrique fabrique = (Fabrique) resultSet.getObject("Fabrique");
                org.youcode.foracademy.models.Class aclass = (org.youcode.foracademy.models.Class) resultSet.getObject("Class");
                Specialiter specialiter = (Specialiter) resultSet.getObject("Specialiter");
                Student student = new Student(resultSet.getLong("id_user"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getLong("phone"),resultSet.getString("gander"),resultSet.getBoolean("status_compte"),role,adress,fabrique,aclass,specialiter);

                students.add(student);
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
        return students;
    }
    @Override
    public Student findById(long id_user){
        Connection con = DbConnection.getConnection();
        if (con == null){
            return null;
        }
        String query =" SELECT  FROM student WHERE id_user = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setLong(1,id_user);
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){
                Role role = (Role)resultSet.getObject("Role");
                Adress adress = (Adress) resultSet.getObject("Adress");
                Fabrique fabrique = (Fabrique) resultSet.getObject("Fabrique");
                Specialiter specialiter = (Specialiter) resultSet.getObject("Specialiter");
                org.youcode.foracademy.models.Class aclass = (Class) resultSet.getObject("Class");

                Student student= new Student(resultSet.getLong("id_user"),resultSet.getString("first_name"),
                        resultSet.getString("last_name"),resultSet.getString("email"),resultSet.getString("password"),
                        resultSet.getLong("phone"),resultSet.getString("gander"),resultSet.getBoolean("status_compte"),
                        role,adress,fabrique,aclass,specialiter);
                return student;
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
    public Student insert(Student student){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return null ;
        }else if (student.getId_user() == 0){
            String query =" INSERT INTO student (first_name,last_name,email,password,phone,gander,status_compte,id_role,id_adress,id_fabrique,id_class,id_specialiter VALUES (?,?,?,?,?,?,?,?,?,?,?,?)) ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, student.getFirst_name());
                preparedStatement.setString(2, student.getLast_name());
                preparedStatement.setString(3, student.getEmail());
                preparedStatement.setString(4, student.getPassword());
                preparedStatement.setLong(5,student.getPhone());
                preparedStatement.setString(6,student.getGander());
                preparedStatement.setBoolean(7,student.isStatus_compte());
                preparedStatement.setLong(8, student.getRole().getId_role());
                preparedStatement.setLong(9,student.getAdress().getId_adress());
                preparedStatement.setLong(10,student.getFabrique().getId_fabrique());
                preparedStatement.setLong(11,student.getAclass().getId_class());
                preparedStatement.setLong(12,student.getSpecialiter().getId_specialiter());
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
        return student;

    }
    @Override
    public Student update(Student student){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return null;
        }else if (student.getId_user()!=0){
            String query =" UPDATE  student SET first_name = ?,last_name = ?,email = ?,password = ?,phone = ?,gander = ?,status_compte = ?,id_role = ?,id_adress = ? ,id_event = ? ,id_fabrique = ? ,id_class = ?,id_specialiter = ? WHERE id_user = ? ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, student.getFirst_name());
                preparedStatement.setString(2, student.getLast_name());
                preparedStatement.setString(3, student.getEmail());
                preparedStatement.setString(4, student.getPassword());
                preparedStatement.setLong(5,student.getPhone());
                preparedStatement.setString(6,student.getGander());
                preparedStatement.setBoolean(7,student.isStatus_compte());
                preparedStatement.setLong(8, student.getRole().getId_role());
                preparedStatement.setLong(9,student.getAdress().getId_adress());
                preparedStatement.setLong(11,student.getFabrique().getId_fabrique());
                preparedStatement.setLong(12,student.getAclass().getId_class());
                preparedStatement.setLong(13,student.getSpecialiter().getId_specialiter());
                preparedStatement.setLong(14,student.getId_user());
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
        return student;
    }
}
