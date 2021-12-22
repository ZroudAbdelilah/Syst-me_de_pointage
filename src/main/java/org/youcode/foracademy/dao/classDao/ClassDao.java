package org.youcode.foracademy.dao.classDao;

import org.youcode.foracademy.models.Class;
import org.youcode.foracademy.models.Promotion;

import java.util.List;

public interface ClassDao {
    public long delete(long id);
    public List<Class> findAll();
    public Class findById(long id);
    public void insert(Class aclass);
    public void update(Class aclass);
}
