package org.youcode.foracademy.dao.classDao;

import org.youcode.foracademy.models.Class;
import org.youcode.foracademy.models.Promotion;

import java.util.List;

public interface ClassDao {
    public boolean delete(long id);
    public List<Class> findAll();
    public Class findById(long id);
    public Class insert(Class aclass);
    public Class update(Class aclass);
}
