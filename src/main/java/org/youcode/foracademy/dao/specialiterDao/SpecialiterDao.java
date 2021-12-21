package org.youcode.foracademy.dao.specialiterDao;


import org.youcode.foracademy.models.Specialiter;

import java.util.List;

public interface SpecialiterDao {
    public long delete(long id);
    public List<Specialiter> findAll();
    public Specialiter findById(long id);
    public void insert(Specialiter specialiter);
    public void update(Specialiter specialiter);
}
