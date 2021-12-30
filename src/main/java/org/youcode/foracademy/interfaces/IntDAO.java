package org.youcode.foracademy.interfaces;

import org.youcode.foracademy.models.Role;
import org.youcode.foracademy.util.DbConnection;
import java.sql.Connection;
import java.util.List;

public interface IntDAO<T> {

    public Connection connect = DbConnection.getConnection();

    public abstract T create(T obj);
    public abstract List readAll();
    public abstract T read(long id);
    public abstract T update(T obj);
    public abstract void delete(T obj);

}