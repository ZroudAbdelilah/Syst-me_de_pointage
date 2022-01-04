package org.youcode.foracademy.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.youcode.foracademy.dao.DAOFactory;
import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.*;
import org.youcode.foracademy.models.Class;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;


class RoleServiceTest {

    @Test
    void read() {
        RoleService roleService = new RoleService();
        assertInstanceOf(Role.class,roleService.read(1));
    }

    @Test
    void readAll() {
        RoleService roleService = new RoleService();
        ArrayList<Role> roles = new ArrayList<Role>();
        assertInstanceOf(roles.getClass(),roleService.readAll());
    }

    @Test
    void delete() {
        RoleService roleService = new RoleService();
        Role role = roleService.read(3);
        assertInstanceOf(Role.class,roleService.delete(role));
    }

    @Test
    void create() {
        RoleService roleService = new RoleService();
        Role role1 = new Role("RolecreatedWITHtest2","Role description", true);
        assertInstanceOf(Role.class,roleService.create(role1));
    }

    @Test
    void update() {
        RoleService roleService = new RoleService();
        Role role2 = new Role(17,"RolemodifiedWITHtest2","Role description", true);
        assertInstanceOf(Role.class,roleService.update(role2));
    }
}