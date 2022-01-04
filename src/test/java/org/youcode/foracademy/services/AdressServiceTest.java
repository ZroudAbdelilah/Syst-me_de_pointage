package org.youcode.foracademy.services;

import org.junit.jupiter.api.Test;
import org.youcode.foracademy.models.Adress;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AdressServiceTest {

    @Test
    void read() {
        AdressService adressService = new AdressService();
        assertInstanceOf(Adress.class,adressService.read(1));
    }

    @Test
    void readAll() {
        AdressService adressService = new AdressService();
        ArrayList<Adress> adresss = new ArrayList<Adress>();
        assertInstanceOf(adresss.getClass(),adressService.readAll());
    }

    @Test
    void delete() {
        AdressService adressService = new AdressService();
        Adress adressDelete = adressService.read(6);
        assertInstanceOf(Adress.class,adressService.delete(adressDelete));
    }

    @Test
    void create() {
        AdressService adressService = new AdressService();
        Adress adress1 = new Adress("ALGERIE", "GRANDE CASA", "CASABLANCA", 20540, true);
        assertInstanceOf(Adress.class,adressService.create(adress1));
    }

    @Test
    void update() {
        AdressService adressService = new AdressService();
        Adress adressUpdate = new Adress(2, "Maroc", "UPDATE", "ASFI", 666, false);
        assertInstanceOf(Adress.class,adressService.update(adressUpdate));
    }
}