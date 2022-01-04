package org.youcode.foracademy.services;

import org.youcode.foracademy.interfaceImp.FabriqueDao;
import org.youcode.foracademy.models.Fabrique;
import java.util.List;

//Go to the class and click alt + enter to generate jUnite tests boilerplate
public class FabriqueService {

    private FabriqueDao fabriqueDao;

    public FabriqueService() {
        this.fabriqueDao = new FabriqueDao();
    }

    public FabriqueService(FabriqueDao fabriqueDao) {
        this.fabriqueDao = fabriqueDao;
    }

    public Fabrique read(long id) {
        return fabriqueDao.read(id);
    }

    public List<Fabrique> readAll() {
        return fabriqueDao.readAll();
    }

    public Fabrique delete(Fabrique fabrique) {
        return fabriqueDao.delete(fabrique);
    }

    public Fabrique create(Fabrique fabrique) {
        return fabriqueDao.create(fabrique);
    }

    public Fabrique update(Fabrique fabrique) {
        return fabriqueDao.update(fabrique);
    }
}


