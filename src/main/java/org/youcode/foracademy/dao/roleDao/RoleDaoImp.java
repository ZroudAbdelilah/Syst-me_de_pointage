package org.youcode.foracademy.dao.roleDao;
import org.youcode.foracademy.dao.DAOException.DAOException;
import org.youcode.foracademy.dao.userDao.UserDao;
import org.youcode.foracademy.models.Role;
import org.youcode.foracademy.models.User;
import org.youcode.foracademy.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class RoleDaoImp implements RoleDao {

    /* Delete role */
    @Override
    public void deleteRole(Role role) throws DAOException {

        /* the db connection verification  */
        try {
            Connection connection = DbConnection.getConnection();
            if (Long.valueOf(role.getId_role()) != null) {
                PreparedStatement statement = connection.prepareStatement
                        ("update roles set status_role = ? where id_role = ?;");
                statement.setBoolean(1, false);
                statement.setLong(2, role.getId_role());
                statement.execute();
            }
            System.out.println("Le role " + role.getId_role() + " a été desactiver avec succèes.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(role.getId_role() + "non desactiver");

        }
    }

    /* Update role */
    @Override
    public void updateRole(Role role) throws DAOException {

        /* the db connection verification  */
        try {
            Connection connection = DbConnection.getConnection();
            if (Long.valueOf(role.getId_role()) != null) {
                PreparedStatement statement = connection.prepareStatement
                        ("update roles set name_role = ? where id_role = ?;");
                statement.setString(1, role.getName_role());
                statement.setLong(2, role.getId_role());
                statement.execute();
            }
            System.out.println("Le role " + role.getId_role() + " a été modifier avec succèes.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(role.getId_role() + "non modifier");

        }
    }


    /* Create role */
    @Override
    public void createRole(Role role) throws DAOException {
        try {
            Connection connection = DbConnection.getConnection();
            if (Long.valueOf(role.getId_role()) != null) {
                PreparedStatement statement = connection.prepareStatement
                        ("insert into roles (id_role, name_role, description_role, status_role)  " +
                                "values (?,?,?,?);");
                statement.setLong(1, role.getId_role());
                statement.setString(2, role.getName_role());
                statement.setString(3, role.getDescription_role());
                statement.setBoolean(4,true);
                statement.execute();
            }
            System.out.println("Le role " + role.getName_role() + " a été créer avec succèes.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(role.getId_role() + "non creer");

        }
    }


    @Override
    public List<Role> findAll(){
        Connection con =DbConnection.getConnection();
        if (con == null){
            return null;
        }
        List<Role> roles =new LinkedList<>();
        String query ="SELECT * FROM roles";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Role role =new Role(resultSet.getLong("id_role"),resultSet.getString("name_role"),resultSet.getString("description_role"),resultSet.getBoolean("status_role"));
                roles.add(role);
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
        return roles;
    }


}
