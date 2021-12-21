package org.youcode.foracademy.test;


import org.youcode.foracademy.dao.roleDao.RoleDao;
import org.youcode.foracademy.dao.roleDao.RoleDaoImp;
import org.youcode.foracademy.dao.userDao.UserDao;
import org.youcode.foracademy.dao.userDao.UserDaoImp;
import org.youcode.foracademy.models.Role;

public class App {
    public static void main(String[] args) {

        RoleDao roleDao = new RoleDaoImp();

        Role role = new Role(
                0,
                "Formateur",
                "Description",
                true
        );

        roleDao.createRole(role);


       /* FormateurDao formateurDao =new FormateurDaoImp();
        Formateur formateur = new Formateur (0,"abdelilah","zroud","abdo@gmail.com","1234",06302332323,"M",false,new Role(),new Adress(),new Event(),new Fabrique(),new Specialiter());
        formateurDao.insert(formateur);//create
        formateurDao.update(formateur);//update
        formateurDao.findAll().forEach(System.out::println);//getall
        Formateur formateur1 =formateurDao.findById(1);//getone
        System.out.println(formateur1);
        formateurDao.delete(1);
        System.out.println("succes");*/
    }
}
