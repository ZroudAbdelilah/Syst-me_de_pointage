package org.youcode.foracademy.services;

import org.youcode.foracademy.interfaceImp.PointeurDao;
import org.youcode.foracademy.models.Pointeur;
import java.util.List;

//Go to the class and click alt + enter to generate jUnite tests boilerplate
public class PointeurService {

    private PointeurDao pointeurDao;

    public PointeurService() {
        this.pointeurDao = new PointeurDao();
    }

    public PointeurService(PointeurDao pointeurDao) {
        this.pointeurDao = pointeurDao;
    }

    public Pointeur read(long id) {
        return pointeurDao.read(id);
    }

    public List<Pointeur> readAll() {
        return pointeurDao.readAll();
    }

    public Pointeur delete(Pointeur pointeur) {
        return pointeurDao.delete(pointeur);
    }

    public Pointeur create(Pointeur pointeur) {
        return pointeurDao.create(pointeur);
    }

    public Pointeur update(Pointeur pointeur) {
        return pointeurDao.update(pointeur);
    }
}


