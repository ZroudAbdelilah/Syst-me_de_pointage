package org.youcode.foracademy.interfaces;

import org.youcode.foracademy.models.Formateur;

import java.util.List;

public interface FormateurDao  {
    boolean delete(long id);
    List<Formateur> findAll();
    Formateur findById(long id);
    Formateur insert(Formateur formateur);
    Formateur update(Formateur formateur);


}
