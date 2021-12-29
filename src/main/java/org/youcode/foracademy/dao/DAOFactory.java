package org.youcode.foracademy.dao;

import org.youcode.foracademy.daoImp.RoleDaoImp;


/*import com.ycbank.daoImpl.EmployeeImpl;
import com.ycbank.daoImpl.PersonImpl;
import com.ycbank.daoImpl.StudentImpl;

import com.ycbank.interfaceImpl.IPersonImpl;
import com.ycbank.interfaceImpl.IStudentImpl;

import com.ycbank.model.Coach;
import com.ycbank.model.Employee;
import com.ycbank.model.Person;
import com.ycbank.model.Student;*/
import org.youcode.foracademy.models.Role;


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



/*interface*/
/*
    public static DAO<Admin> getAdminImpl(){ return new AdminImpl(); }
*/
    public static RoleDaoImp<Role> getRoleImpl(){ return new RoleDaoImp<Role>(); }
}
