package org.youcode.foracademy.services;

import org.youcode.foracademy.interfaceImp.RoleDao;
import org.youcode.foracademy.models.Role;
import java.util.List;

//Go to the class and click alt + enter to generate jUnite tests boilerplate
public class RoleService {

    private RoleDao roleDao;

    public RoleService() {
        this.roleDao = new RoleDao();
    }

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role read(long id) {
        return roleDao.read(id);
    }

    public List<Role> readAll() {
        return roleDao.readAll();
    }

    public Role delete(Role role) {
        return roleDao.delete(role);
    }

    public Role create(Role role) {
        return roleDao.create(role);
    }

    public Role update(Role role) {
        return roleDao.update(role);
    }
}


