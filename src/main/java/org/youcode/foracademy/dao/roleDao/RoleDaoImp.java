package org.youcode.foracademy.dao.roleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jetbrains.annotations.NotNull;
import org.youcode.foracademy.dao.DAOException.DAOException;
import org.youcode.foracademy.models.Role;
import org.youcode.foracademy.util.DbConnection;

public class RoleDaoImp implements RoleDao {
    public RoleDaoImp() {
    }

    public void deleteRole(@NotNull Role role) throws DAOException {
        try {
            Connection connection = DbConnection.getConnection();
            if (role.getId_role() != 0) {
                PreparedStatement statement = connection.prepareStatement("update roles set status_role = ? where id_role = ?;");
                statement.setBoolean(1, false);
                statement.setLong(2, role.getId_role());
                statement.execute();
            }

            System.out.println("Le role " + role.getId_role() + " a été desactiver avec succèes.");
        } catch (SQLException var4) {
            var4.printStackTrace();
            System.out.println(role.getId_role() + "non desactiver");
        }

    }
}