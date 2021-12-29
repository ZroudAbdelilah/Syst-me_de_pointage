package org.youcode.foracademy.dao.roleDao;

import org.youcode.foracademy.dao.DAOException.DAOException;
import org.youcode.foracademy.models.Role;

public interface RoleDao {
    void deleteRole(Role role) throws DAOException;
}
