package org.youcode.foracademy.services;

import org.youcode.foracademy.interfaceImp.AdressDao;
import org.youcode.foracademy.models.Adress;
import java.util.List;

//Go to the class and click alt + enter to generate jUnite tests boilerplate
public class AdressService {

    private AdressDao adressDao;

    public AdressService() {
        this.adressDao = new AdressDao();
    }

    public AdressService(AdressDao adressDao) {
        this.adressDao = adressDao;
    }

    public Adress read(long id) {
        return adressDao.read(id);
    }

    public List<Adress> readAll() {
        return adressDao.readAll();
    }

    public Adress delete(Adress adress) {
        return adressDao.delete(adress);
    }

    public Adress create(Adress adress) {
        return adressDao.create(adress);
    }

    public Adress update(Adress adress) {
        return adressDao.update(adress);
    }
}


