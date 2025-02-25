package edu.icet.repository;

import java.util.ArrayList;


public interface CrudRepository<T> extends SuperRepository {

//    boolean save(T entity) throws SQLException;
//
//    boolean delete(Id id) throws SQLException;

    ArrayList<T> gettAll();

//    boolean update(T entity);
//
//    T search(Id id);
//
//    Integer getNextId();
}
