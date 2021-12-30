package org.youcode.foracademy.interfaces;


import org.youcode.foracademy.models.Specialiter;

import java.util.List;

public interface SpecialiterDao {
    public boolean delete(long id);
    public List<Specialiter> findAll();
    public Specialiter findById(long id);
    public Specialiter insert(Specialiter specialiter);
    public Specialiter update(Specialiter specialiter);
}
