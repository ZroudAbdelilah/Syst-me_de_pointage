package org.youcode.foracademy.services;

import org.junit.jupiter.api.Test;
import org.youcode.foracademy.models.*;
import org.youcode.foracademy.models.Class;

import java.sql.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void findById() {
        StudentService studentService = new StudentService();
        assertInstanceOf(Student.class,studentService.findById(1));
    }

    @Test
    void findAll() {
        StudentService studentService = new StudentService();
        LinkedList<Student> students = new LinkedList<Student>();
        assertInstanceOf(students.getClass(),studentService.findAll());
    }

    @Test
    void delete() {
        StudentService studentService = new StudentService();
        assertTrue(studentService.delete(1));
    }

    @Test
    void insert() {
        StudentService studentService = new StudentService();
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
        org.youcode.foracademy.models.Class aclass = new org.youcode.foracademy.models.Class(0,"java",new Date(11,11,11),new Date(111,11,13),promotion);
        assertInstanceOf(Class.class,classService.insert(aclass));
        SpecialiterService specialiterService = new SpecialiterService();
        Specialiter specialiter = new Specialiter(0,"javaEE","testinser");
        assertInstanceOf(Specialiter.class,specialiterService.insert(specialiter));
        Student student = new Student(0,"abdo","zroud","zroud@gmail.com","1234",063534534,"M",false,role,adress,fabrique,aclass,specialiter);
        assertInstanceOf(Student.class,studentService.insert(student));
    }

    @Test
    void update() {
        StudentService studentService = new StudentService();
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
        org.youcode.foracademy.models.Class aclass = new org.youcode.foracademy.models.Class(0,"java",new Date(11,11,11),new Date(111,11,13),promotion);
        assertInstanceOf(Class.class,classService.insert(aclass));
        SpecialiterService specialiterService = new SpecialiterService();
        Specialiter specialiter = new Specialiter(0,"javaEE","testinser");
        assertInstanceOf(Specialiter.class,specialiterService.insert(specialiter));
        Student student = new Student(1,"abdotestupdate","zroud","zroud@gmail.com","1234",063534534,"M",false,role,adress,fabrique,aclass,specialiter);
        assertInstanceOf(Student.class,studentService.update(student));
    }
}