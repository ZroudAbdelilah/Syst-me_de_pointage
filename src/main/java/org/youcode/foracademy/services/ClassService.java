package org.youcode.foracademy.services;

import org.youcode.foracademy.interfaces.ClassDao;

import org.youcode.foracademy.models.Class;


import java.util.List;

public class ClassService {
   private ClassDao classDao;

    public ClassService(ClassDao classDao) {
        this.classDao = classDao;
    }

    public Class findById(long id){
        return classDao.findById(id);
    }
    public List<Class> findAll(){
        return classDao.findAll();
    }
    public boolean delete(long id){
        return classDao.delete(id);
    }
    public Class insert(Class aclass){
        return classDao.insert(aclass);
    }
    public Class update(Class aclass){
        return classDao.insert(aclass);
    }
}
