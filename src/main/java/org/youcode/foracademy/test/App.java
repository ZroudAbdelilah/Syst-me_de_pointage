package org.youcode.foracademy.test;

import org.youcode.foracademy.dao.formateurDao.FormateurDao;
import org.youcode.foracademy.dao.formateurDao.FormateurDaoImp;
import org.youcode.foracademy.dao.specialiterDao.SpecialiterDao;
import org.youcode.foracademy.dao.specialiterDao.SpecialiterDaoImp;
import org.youcode.foracademy.models.*;
import org.youcode.foracademy.util.DbConnection;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
       /* FormateurDao formateurDao =new FormateurDaoImp();
        Formateur formateur = new Formateur (0,"abdelilah","zroud","abdo@gmail.com","1234",06302332323,"M",false,new Role(),new Adress(),new Fabrique(),new Specialiter());
        formateurDao.insert(formateur);//create
        formateurDao.update(formateur);//update
        formateurDao.findAll().forEach(System.out::println);//getall
        Formateur formateur1 =formateurDao.findById(1);//getone
        System.out.println(formateur1);
        formateurDao.delete(1);*/


        SpecialiterDao specialiterDao =new SpecialiterDaoImp();
        //Specialiter specialiter = new Specialiter (1,"svt","hello world");
        //specialiterDao.insert(specialiter);//create
       //specialiterDao.update(specialiter);//update
        // specialiterDao.findAll().forEach(System.out::println);//getall
      //Specialiter specialiter1 =specialiterDao.findById(1);//getone
       // System.out.println(specialiter1);
          specialiterDao.delete(1);
        System.out.println("succes");
    }
}
