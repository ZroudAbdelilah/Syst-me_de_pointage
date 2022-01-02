package org.youcode.foracademy.services;

import org.junit.jupiter.api.Test;
import org.youcode.foracademy.models.*;
import org.youcode.foracademy.models.Class;

import java.sql.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FormateurServiceTest {

    @Test
    void findById() {
        FormateurService formateurService = new FormateurService();
        assertInstanceOf(Formateur.class,formateurService.findById(1));
    }

    @Test
    void findAll() {
        FormateurService formateurService = new FormateurService();
        LinkedList<Formateur> formateurs = new LinkedList<Formateur>();
        assertInstanceOf(formateurs.getClass(),formateurService.findAll());
    }

    @Test
    void delete() {
        FormateurService formateurService = new FormateurService();
        assertTrue(formateurService.delete(1));
    }

    @Test
    void insert() {
        FormateurService formateurService = new FormateurService();
        RoleService roleService = new RoleService();
        Role role =new Role(1,"formateur","testunit",true);
        assertInstanceOf(Role.class,roleService.insert(role));
        AdressService adressService = new AdressService();
        Adress adress = new Adress(1,"morocco","merrakech-asfi","youssoufia",46300);
        assertInstanceOf(Adress.class,adressService.insert(adress));
        FabriqueService fabriqueService = new FabriqueService();
        PointeurService pointeurService = new PointeurService();
        Pointeur pointeur = new Pointeur(1,"mdr");
        assertInstanceOf(Pointeur.class,pointeurService.insert(pointeur));
        Fabrique fabrique = new Fabrique(1,"youcode",pointeur,adress);
        assertInstanceOf(Fabrique.class,fabriqueService.insert(fabrique));
        ClassService classService = new ClassService();
        PromotionService promotionService=new PromotionService();
        Promotion promotion = new Promotion(5,"helloooforClass",new Date(11,11,11),new Date(12,12,11),new Date(10,5,22));
        assertInstanceOf(Promotion.class,promotionService.insert(promotion));
        Class aclass = new Class(0,"java",new Date(11,11,11),new Date(111,11,13),promotion);
        assertInstanceOf(Class.class,classService.insert(aclass));
        SpecialiterService specialiterService = new SpecialiterService();
        Specialiter specialiter = new Specialiter(0,"javaEE","testinser");
        assertInstanceOf(Specialiter.class,specialiterService.insert(specialiter));


        Formateur formateur = new Formateur(0,"abdelilah","zr","abdelilah.zr@gmail.com","133214124",06232323232,"M",true,role,adress,fabrique,aclass,specialiter);
        assertInstanceOf(Formateur.class,formateurService.insert(formateur));
    }

    @Test
    void update() {
        FormateurService formateurService = new FormateurService();
        RoleService roleService = new RoleService();
        Role role =new Role(1,"formateur","testunit",true);
        assertInstanceOf(Role.class,roleService.insert(role));
        AdressService adressService = new AdressService();
        Adress adress = new Adress(1,"morocco","merrakech-asfi","youssoufia",46300);
        assertInstanceOf(Adress.class,adressService.insert(adress));
        FabriqueService fabriqueService = new FabriqueService();
        PointeurService pointeurService = new PointeurService();
        Pointeur pointeur = new Pointeur(1,"mdr");
        assertInstanceOf(Pointeur.class,pointeurService.insert(pointeur));
        Fabrique fabrique = new Fabrique(1,"youcode",pointeur,adress);
        assertInstanceOf(Fabrique.class,fabriqueService.insert(fabrique));
        ClassService classService = new ClassService();
        PromotionService promotionService=new PromotionService();
        Promotion promotion = new Promotion(5,"helloooforClass",new Date(11,11,11),new Date(12,12,11),new Date(10,5,22));
        assertInstanceOf(Promotion.class,promotionService.insert(promotion));
        Class aclass = new Class(0,"java",new Date(11,11,11),new Date(111,11,13),promotion);
        assertInstanceOf(Class.class,classService.insert(aclass));
        SpecialiterService specialiterService = new SpecialiterService();
        Specialiter specialiter = new Specialiter(0,"javaEE","testinser");
        assertInstanceOf(Specialiter.class,specialiterService.insert(specialiter));


        Formateur formateur = new Formateur(1,"abdelilahtestupdate","zr","abdelilah.zr@gmail.com","133214124",06232323232,"M",true,role,adress,fabrique,aclass,specialiter);
        assertInstanceOf(Formateur.class,formateurService.update(formateur));
    }
}