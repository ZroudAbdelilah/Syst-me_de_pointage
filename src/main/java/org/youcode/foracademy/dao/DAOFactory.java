package org.youcode.foracademy.dao;






import org.youcode.foracademy.interfaceImp.UserDao;
import org.youcode.foracademy.interfaces.IntDAO;
import org.youcode.foracademy.models.Role;
import org.youcode.foracademy.interfaceImp.RoleDao;
import org.youcode.foracademy.daoImp.RoleDaoImp;
import org.youcode.foracademy.models.User;


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





}
