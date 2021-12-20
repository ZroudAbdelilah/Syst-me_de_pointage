package org.youcode.foracademy.dao.formateurDao;

import org.youcode.foracademy.models.Formateur;

import java.util.List;

public interface FormateurDao  {
    public long delete(long id);
    public List<Formateur> findAll();
    public Formateur findById(long id);
    public void insert(Formateur formateur);
    public void update(Formateur formateur);


}
