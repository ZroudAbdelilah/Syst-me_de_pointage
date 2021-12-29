package org.youcode.foracademy.test;

import org.youcode.foracademy.dao.DAOFactory;
import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Role;

import java.util.List;
import java.util.Objects;

public class App {
    public static void main(String[] args) {
        IntDAO<Role> roleOp = DAOFactory.getRoleImpl();
        Role role1 = new Role(1L,
                "role1",
                "roledescription1",
                true
        );

        Role role2 = new Role(1L,
                "modifini",
                "roledescription2",
                false
        );



 /*       role1 = roleOp.create(role1);
        role1.setName_role("Admin");*/


        List fetchAllRoles = (List) roleOp.readAll();
        Role fetchRoleById = roleOp.read(10L);
/*
        role1 = roleOp.update(role2);
*/
        roleOp.delete(role2);

        if (!Objects.isNull(role1) && !Objects.isNull(role2))
            System.out.println("le role est " + role1.getName_role() + " son status est ." + role1.getStatus_role());
        System.out.println("le role est " + role2.getName_role() + " son status est ." + role2.getStatus_role());
   /*     System.out.println( fetchAllRoles );
        System.out.println("the searched role is " + fetchRoleById);*/
























      /* Class aclass = new Class();
        aclass.setName_class("JAVA/ANGULAR");
        aclass.setStart_of_day(new Date(200,10,17));
        aclass.setEnd_of_day(new Date(200,10,17));

        Specialiter specialiter = new Specialiter();
        specialiter.setName_specialiter("JAVA");
        specialiter.setId_specialiter(1);

       aclass.setPromotion(speciality);
        //System.out.println(classRoom.toString());
        classRoomDaoImp classRoomDaoImp = new classRoomDaoImp();
        classRoomDaoImp.saveClassRoom(classRoom);
        System.out.println(classRoomDaoImp.saveClassRoom(classRoom).toString());
       /* FormateurDao formateurDao =new FormateurDaoImp();
        Formateur formateur = new Formateur (0,"abdelilah","zroud","abdo@gmail.com","1234",06302332323,"M",false,new Role(),new Adress(),new Fabrique(),new Specialiter());
        formateurDao.insert(formateur);//create
        formateurDao.update(formateur);//update
        formateurDao.findAll().forEach(System.out::println);//getall
        Formateur formateur1 =formateurDao.findById(1);//getone
        System.out.println(formateur1);
        formateurDao.delete(1);*/


       /* SpecialiterDao specialiterDao =new SpecialiterDaoImp();
        //Specialiter specialiter = new Specialiter (1,"svt","hello world");
        //specialiterDao.insert(specialiter);//create
       //specialiterDao.update(specialiter);//update
        // specialiterDao.findAll().forEach(System.out::println);//getall
      //Specialiter specialiter1 =specialiterDao.findById(1);//getone
       // System.out.println(specialiter1);
          specialiterDao.delete(1);*/

/*
       PromotionDao promotionDao =new PromotionDaoImp();
*/
          /*Promotion promotion = new Promotion(1,"hello EDIT 2020",new Date(),new Date(120,10,18),new Date(121,11,10));
       // promotionDao.insert(promotion);//create
        //promotionDao.update(promotion);//update
        //promotionDao.findAll().forEach(System.out::println);//getall
        Promotion promotion1 =promotionDao.findById(1);//getone
        System.out.println(promotion1);
        promotionDao.delete(1);*/
        /*ClassDao classDao =new ClassDaoImp();
        Class aclass = new Class(1,"java",new Date(200,10,11),new Date(200,10,11),);
        // promotionDao.insert(promotion);//create
        //promotionDao.update(promotion);//update
        //promotionDao.findAll().forEach(System.out::println);//getall
        Promotion promotion1 =promotionDao.findById(1);//getone
        System.out.println(promotion1);


        System.out.println("succes");*/
        /*   promotionDao.delete(3);
         */
    }
}
