package org.youcode.foracademy.services;

import org.junit.jupiter.api.Test;
import org.youcode.foracademy.models.Fabrique;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class FabriqueServiceTest {

    @Test
    void read() {
        FabriqueService fabriqueService = new FabriqueService();
        assertInstanceOf(Fabrique.class,fabriqueService.read(1));
    }

    @Test
    void readAll() {
        FabriqueService fabriqueService = new FabriqueService();
        ArrayList<Fabrique> fabriques = new ArrayList<Fabrique>();
        assertInstanceOf(fabriques.getClass(),fabriqueService.readAll());
    }

    @Test
    void delete() {
        FabriqueService fabriqueService = new FabriqueService();
        Fabrique fabriqueDelete = fabriqueService.read(4);
        assertInstanceOf(Fabrique.class,fabriqueService.delete(fabriqueDelete));
    }

    @Test
    void create() {
        FabriqueService fabriqueService = new FabriqueService();
        Fabrique fabrique1 = new Fabrique("Youcode YFIA", true);
        assertInstanceOf(Fabrique.class,fabriqueService.create(fabrique1));

    }

    @Test
    void update() {
        FabriqueService fabriqueService = new FabriqueService();
        Fabrique fabriqueUpdate = new Fabrique(1,"Youcode Youssoufia", null, null, true);
        assertInstanceOf(Fabrique.class,fabriqueService.update(fabriqueUpdate));
    }
}