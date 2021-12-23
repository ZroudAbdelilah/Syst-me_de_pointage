package org.youcode.foracademy.dao.promotionDao;

import org.youcode.foracademy.models.Promotion;
import org.youcode.foracademy.util.DbConnection;
import org.youcode.foracademy.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PromotionDaoImp implements PromotionDao{
    @Override
    public boolean delete(long id_promotion){
        Connection con = DbConnection.getConnection();
        if (con == null){
            return false;
        }
        String query ="DELETE FROM promotion WHERE id_promotion = ? ";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setLong(1,id_promotion);
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
    public List<Promotion> findAll(){
        Connection con =DbConnection.getConnection();
        if (con == null){
            return null;
        }
        List<Promotion> promotions =new LinkedList<>();
        String  query = "SELECT * FROM promotion";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                Promotion promotion = new Promotion(resultSet.getLong("id_promotion"),resultSet.getString("name"),resultSet.getDate("year"),resultSet.getDate("star_date"),resultSet.getDate("end_date"));

                promotions.add(promotion);
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
        return promotions;
    }
    @Override
    public Promotion findById(long id_promotion){
        Connection con = DbConnection.getConnection();
        if (con == null){
            return null;
        }
        String query =" SELECT * FROM promotion WHERE id_promotion = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setLong(1,id_promotion);
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){

                Promotion promotion = new Promotion(resultSet.getLong("id_promotion"),resultSet.getString("name"),resultSet.getDate("year"),resultSet.getDate("star_date"),resultSet.getDate("end_date"));
                return promotion;
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
    public Promotion insert(Promotion promotion){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return null;
        }else if (promotion.getId_promotion() == 0) {
            String query =" INSERT INTO promotion (name, year,star_date,end_date) VALUES (?,?,?,?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, promotion.getName());
                preparedStatement.setDate(2, Utils.getSqlDate(promotion.getYear()));
                preparedStatement.setDate(3,Utils.getSqlDate(promotion.getStar_date()));
                preparedStatement.setDate(4,Utils.getSqlDate(promotion.getEnd_date()));

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
        return promotion;

    }
    @Override
    public Promotion update(Promotion promotion){
        Connection con = DbConnection.getConnection();
        if(con == null ){
            return null;
        }else if (promotion.getId_promotion() > 0){

            String query = " UPDATE  promotion  SET name = ?,year = ?,star_date = ?,end_date = ? WHERE id_promotion = ? ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, promotion.getName());
                preparedStatement.setDate(2, Utils.getSqlDate(promotion.getYear()));
                preparedStatement.setDate(3,Utils.getSqlDate(promotion.getStar_date()));
                preparedStatement.setDate(4,Utils.getSqlDate(promotion.getEnd_date()));
                preparedStatement.setLong(5,promotion.getId_promotion());
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
        return promotion;
    }

}
