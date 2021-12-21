package org.youcode.foracademy.dao.roleDao;
import org.youcode.foracademy.dao.DAOException.DAOException;
import org.youcode.foracademy.models.Formateur;
import org.youcode.foracademy.models.Role;

import java.util.List;


public interface RoleDao {
    void deleteRole(Role role) throws DAOException;
    void updateRole(Role role) throws DAOException;
    void createRole(Role role) throws DAOException;
    public List<Role> findAll();



    /* Delete role */
/*
    void deleteRole(Role role) throws DAOException;
*/
/*    public List<Formateur> findAll();
    public Formateur findById(long id);
    public void insert(Formateur formateur);
    public void update(Formateur formateur);*/


}
