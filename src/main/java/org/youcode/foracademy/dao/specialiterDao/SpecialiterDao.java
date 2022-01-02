package org.youcode.foracademy.dao.specialiterDao;


import org.youcode.foracademy.models.Specialiter;

import java.util.List;

public interface SpecialiterDao {
     boolean delete(long id);
     List<Specialiter> findAll();
    Specialiter findById(long id);
    public Specialiter insert(Specialiter specialiter);
    public Specialiter update(Specialiter specialiter);
}
