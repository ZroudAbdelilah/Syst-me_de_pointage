package org.youcode.foracademy.dao.classDao;

import org.youcode.foracademy.models.Class;
import org.youcode.foracademy.models.Promotion;
import org.youcode.foracademy.util.DbConnection;
import org.youcode.foracademy.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ClassDaoImp implements ClassDao {
    @Override
    public long delete(long id_class){
        Connection con = DbConnection.getConnection();
        if (con == null){
            return 0;
        }
        String query ="DELETE FROM class WHERE id_class = ? ";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setLong(1,id_class);
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
    public List<Class> findAll(){
        Connection con =DbConnection.getConnection();
        if (con == null){
            return null;
        }
        List<Class> aclasss =new LinkedList<>();
        String  query = "SELECT * FROM class";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                Promotion promotion = (Promotion) resultSet.getObject("Promotion");
                Class aclass = new Class(resultSet.getLong("id_class"),resultSet.getString("name_class"),resultSet.getDate("start_of_day"),resultSet.getDate("end_of_day"),promotion);

                aclasss.add(aclass);
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
        return aclasss;
    }
    @Override
    public Class findById(long id_class){
        Connection con = DbConnection.getConnection();
        if (con == null){
            return null;
        }
        String query =" SELECT * FROM class WHERE id_class = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setLong(1,id_class);
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){
                Promotion promotion = (Promotion) resultSet.getObject("Promotion");
                Class aclass = new Class(resultSet.getLong("id_class"),resultSet.getString("name_class"),resultSet.getDate("start_of_day"),resultSet.getDate("end_of_day"),promotion);
                return aclass;
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
    public void insert(Class aclass){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return ;
        }else if (aclass.getId_class() == 0) {

            String query =" INSERT INTO class (name_class, ,start_of_date,end_of_date,id_promotion) VALUES (?,?,?,?,?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, aclass.getName_class());
                preparedStatement.setDate(2, Utils.getSqlDate(aclass.getStart_of_day()));
                preparedStatement.setDate(3,Utils.getSqlDate(aclass.getEnd_of_day()));
                preparedStatement.setLong(4, aclass.getPromotion().getId_promotion());

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
    public void update(Class aclass){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return ;
        }else if (aclass.getId_class() > 0){

            String query = " UPDATE  class  SET name_class = ?,start_of_day = ?,end_of_day = ?,id_promotion = ? WHERE id_class = ? ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, aclass.getName_class());
                preparedStatement.setDate(2, Utils.getSqlDate(aclass.getStart_of_day()));
                preparedStatement.setDate(3,Utils.getSqlDate(aclass.getEnd_of_day()));
                preparedStatement.setLong(4, aclass.getPromotion().getId_promotion());
                preparedStatement.setLong(5,aclass.getId_class());
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
