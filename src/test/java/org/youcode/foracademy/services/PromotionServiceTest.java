package org.youcode.foracademy.services;

import org.junit.jupiter.api.Test;
import org.youcode.foracademy.dao.promotionDao.PromotionDao;
import org.youcode.foracademy.models.Promotion;


import java.util.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PromotionServiceTest {


    @Test
    void findById() {

        PromotionService promotionService =new PromotionService();
        assertInstanceOf(Promotion.class,promotionService.findById(2));


    }

    @Test
    void findAll() {
        PromotionService promotionService=new PromotionService();
       LinkedList<Promotion> promotions = new LinkedList<Promotion>();
        assertInstanceOf(promotions.getClass(),promotionService.findAll());

    }

    @Test
    void delete() {
        PromotionService promotionService=new PromotionService();
        assertTrue(promotionService.delete(4));
    }

    @Test
    void insert() {
        PromotionService promotionService=new PromotionService();
        Promotion promotion = new Promotion(0,"hellooo",new Date(11,11,11),new Date(12,12,11),new Date(10,5,22));
        assertInstanceOf(Promotion.class,promotionService.insert(promotion));
    }

    @Test
    void update() {
        PromotionService promotionService=new PromotionService();
        Promotion promotion = new Promotion(5,"helloootest",new Date(11,11,11),new Date(12,12,11),new Date(10,5,22));
        assertInstanceOf(Promotion.class,promotionService.update(promotion));
    }
}