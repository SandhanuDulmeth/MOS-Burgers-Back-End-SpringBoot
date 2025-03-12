package edu.icet.repository;

import java.sql.SQLException;
import java.util.ArrayList;


public interface CrudRepository<T> extends SuperRepository {

    boolean save(T entity) ;
//
    boolean delete(String id) ;

    ArrayList<T> gettAll();

    boolean update(T entity);

//    T search(Id id);
//
//    Integer getNextId();
}
