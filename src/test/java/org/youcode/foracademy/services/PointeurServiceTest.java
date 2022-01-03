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


class PointeurServiceTest {

    @Test
    void read() {
        PointeurService pointeurService = new PointeurService();
        assertInstanceOf(Pointeur.class,pointeurService.read(1));
    }

    @Test
    void readAll() {
        PointeurService pointeurService = new PointeurService();
        LinkedList<Pointeur> pointeurs = new LinkedList<Pointeur>();
        assertInstanceOf(pointeurs.getClass(),pointeurService.readAll());
    }

    @Test
    void delete() {
        PointeurService pointeurService = new PointeurService();
        Pointeur pointeurDelete = pointeurService.read(4);
        assertInstanceOf(Pointeur.class,pointeurService.delete(pointeurDelete));
    }

    @Test
    void create() {
        PointeurService pointeurService = new PointeurService();
        Pointeur pointeur1 = new Pointeur(true,"OMICRON");
        Pointeur pointeur2 = new Pointeur(true,"NOTWORKING");
        assertInstanceOf(Pointeur.class,pointeurService.create(pointeur2));
        assertInstanceOf(Pointeur.class,pointeurService.create(pointeur1));
    }

    @Test
    void update() {
        PointeurService pointeurService = new PointeurService();
        Pointeur modifyPointeur = new Pointeur(5,"didi", false);
        assertInstanceOf(Pointeur.class,pointeurService.update(modifyPointeur));
    }
}