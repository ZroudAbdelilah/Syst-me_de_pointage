package org.youcode.foracademy.dao;






import org.youcode.foracademy.interfaceImp.*;
import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.*;
import org.youcode.foracademy.daoImp.RoleDaoImp;


public class DAOFactory {

/* abstract examples */
/*    public static DAO<Admin> getAdminImpl(){
        return new AdminImpl();
    }
    public static DAO<Student> getStudentImpl(){ return new StudentImpl(); }
    public static DAO<Fprmateur> getFormateurImpl(){
        return new FormateurImpl();
    }
    public static DAO<Coach> getCoachImpl(){
        return new CoachImpl();
    }*/

    public static IntDAO<Role> getRoleImpl(){ return new RoleDao(); }
    public static IntDAO<User> getUserImpl(){ return new UserDao(); }
    public static IntDAO<Adress> getAdressImpl(){ return new AdressDao(); }
    public static IntDAO<Fabrique> getFabriqueImpl(){ return new FabriqueDao(); }
    public static IntDAO<Pointer> getPointerImpl(){ return new PointerDao(); }
    public static IntDAO<Pointeur> getPointeurImpl(){ return new PointeurDao(); }
    public static IntDAO<Event> getEventImpl(){ return new EventDao(); }









}
