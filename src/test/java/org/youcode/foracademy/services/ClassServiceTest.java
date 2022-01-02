package org.youcode.foracademy.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.youcode.foracademy.dao.classDao.ClassDao;
import org.youcode.foracademy.dao.classDao.ClassDaoImp;
import org.youcode.foracademy.models.Class;
import org.youcode.foracademy.models.Promotion;

import java.sql.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ClassServiceTest {


    @Test
     void findById() {

        ClassService classService = new ClassService();
        assertInstanceOf(Class.class,classService.findById(1));
    }

    @Test
    void findAll() {

        ClassService classService = new ClassService();
        LinkedList<Class> classes = new LinkedList<Class>();
        assertInstanceOf(classes.getClass(),classService.findAll());
    }

    @Test
    void delete() {

        ClassService classService = new ClassService();

        assertTrue(classService.delete(2));
    }

    @Test
    void insert() {
        ClassService classService = new ClassService();
        PromotionService promotionService=new PromotionService();
        Promotion promotion = new Promotion(5,"helloooforClass",new Date(11,11,11),new Date(12,12,11),new Date(10,5,22));
        assertInstanceOf(Promotion.class,promotionService.insert(promotion));

        Class aclass = new Class(0,"java",new Date(11,11,11),new Date(111,11,13),promotion);

        assertInstanceOf(Class.class,classService.insert(aclass));
    }

    @Test
    void update() {
        ClassService classService = new ClassService();
        PromotionService promotionService=new PromotionService();
        Promotion promotion = new Promotion(5,"helloooforClass",new Date(11,11,11),new Date(12,12,11),new Date(10,5,22));
        assertInstanceOf(Promotion.class,promotionService.insert(promotion));

        Class aclass = new Class(1,"javatestupdate",new Date(11,11,11),new Date(111,11,13),promotion);

        assertInstanceOf(Class.class,classService.update(aclass));
    }
}