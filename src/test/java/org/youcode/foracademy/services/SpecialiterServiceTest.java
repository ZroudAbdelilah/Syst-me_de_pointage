package org.youcode.foracademy.services;

import org.junit.jupiter.api.Test;
import org.youcode.foracademy.models.Specialiter;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SpecialiterServiceTest {


    @Test
    void findById() {
        SpecialiterService specialiterService = new SpecialiterService();
        assertInstanceOf(Specialiter.class,specialiterService.findById(2));
    }

    @Test
    void findAll() {
        SpecialiterService specialiterService = new SpecialiterService();
        LinkedList<Specialiter> specialiters = new LinkedList<Specialiter>();
        assertInstanceOf(specialiters.getClass(),specialiterService.findAll());

    }

    @Test
    void delete() {
        SpecialiterService specialiterService = new SpecialiterService();
        assertTrue(specialiterService.delete(2));
    }

    @Test
    void insert() {
        SpecialiterService specialiterService = new SpecialiterService();
        Specialiter specialiter = new Specialiter(0,"javaEE","testinser");
        assertInstanceOf(Specialiter.class,specialiterService.insert(specialiter));
    }

    @Test
    void update() {
        SpecialiterService specialiterService = new SpecialiterService();
        Specialiter specialiter = new Specialiter(3,"javaEE","testupdate");
        assertInstanceOf(Specialiter.class,specialiterService.update(specialiter));
    }
}