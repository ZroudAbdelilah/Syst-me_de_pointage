package org.youcode.foracademy.services;


import org.youcode.foracademy.interfaceImp.FormateurDao;
import org.youcode.foracademy.models.Formateur;

import java.util.List;

public class FormateurService {
    private FormateurDao formateurDao;

    public FormateurService(FormateurDao formateurDao) {
        this.formateurDao = formateurDao;
    }

    public Formateur findById(long id){
        return formateurDao.findById(id);
    }
    public List<Formateur> findAll(){
        return formateurDao.findAll();
    }
    public boolean delete(long id){
        return formateurDao.delete(id);
    }
    public Formateur insert(Formateur formateur){
        return formateurDao.insert(formateur);
    }
    public Formateur update(Formateur formateur){
        return formateurDao.insert(formateur);
    }
}
