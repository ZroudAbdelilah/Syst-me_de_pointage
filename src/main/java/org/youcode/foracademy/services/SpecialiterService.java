package org.youcode.foracademy.services;

import org.youcode.foracademy.interfaceImp.SpecialiterDao;
import org.youcode.foracademy.models.Specialiter;

import java.util.List;

public class SpecialiterService {
    private SpecialiterDao specialiterDao;

    public SpecialiterService(SpecialiterDao specialiterDao) {
        this.specialiterDao = specialiterDao;
    }
    public Specialiter findById(long id){
        return specialiterDao.findById(id);
    }
    public List<Specialiter> findAll(){
        return specialiterDao.findAll();
    }
    public boolean delete(long id){
        return specialiterDao.delete(id);
    }
    public Specialiter insert(Specialiter specialiter){
        return specialiterDao.insert(specialiter);
    }
    public Specialiter update(Specialiter specialiter){
        return specialiterDao.insert(specialiter);
    }
}
