package org.youcode.foracademy.interfaces;

import org.youcode.foracademy.util.DbConnection;
import java.sql.Connection;
import java.util.List;

public interface IntDAO<T> {

     Connection connect = DbConnection.getConnection();
      T create(T obj);
      List readAll();
      T read(long id);
      T update(T obj);
      T delete(T obj);

}