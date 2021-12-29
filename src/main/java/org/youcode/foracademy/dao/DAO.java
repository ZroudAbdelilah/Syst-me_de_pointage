package org.youcode.foracademy.dao;
import org.youcode.foracademy.util.DbConnection;
import java.sql.Connection;

public abstract class DAO<T> {

    public Connection connect = DbConnection.getConnection();

    public abstract T find(long id);
    public abstract T create(T obj);
    public abstract T update(T obj);
    public abstract void delete(T obj);

}