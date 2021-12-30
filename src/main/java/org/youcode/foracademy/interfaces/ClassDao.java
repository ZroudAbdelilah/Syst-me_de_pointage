package org.youcode.foracademy.interfaces;

import org.youcode.foracademy.models.Class;
import org.youcode.foracademy.models.Promotion;

import java.util.List;

public interface ClassDao {
     boolean delete(long id);
     List<Class> findAll();
     Class findById(long id);
     Class insert(Class aclass);
     Class update(Class aclass);
}
