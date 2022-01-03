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
import java.util.LinkedList;


class UserServiceTest {

    @Test
    void read() {
        UserService userService = new UserService();
        assertInstanceOf(User.class,userService.read(1));
    }

    @Test
    void readAll() {
        UserService userService = new UserService();
        LinkedList<User> users = new LinkedList<User>();
        assertInstanceOf(users.getClass(),userService.readAll());
    }

    @Test
    void delete() {
        UserService userService = new UserService();
        User user = userService.read(3);
        assertInstanceOf(User.class,userService.delete(user));
    }

    @Test
    void create() {
        UserService userService = new UserService();
        User user1 = new User("testUserfn","testUserln","jhone@doe.fr", "password",0666, "femme", true, null, null, null);
        assertInstanceOf(User.class,userService.create(user1));
    }

    @Test
    void update() {
        UserService userService = new UserService();
        User user2 = new User(5,"modifieduser","testUserln","jhone@doe.fr", "password",0666, "femme", true, null, null, null);
        assertInstanceOf(User.class,userService.update(user2));
    }
}