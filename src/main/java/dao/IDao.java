package dao;

import java.util.List;

public interface IDao<T> {

    // Cette interface définit les méthodes CRUD communes à toutes les entités.
    boolean create(T o);
    boolean delete(T o);
    boolean update(T o);
    T findById(int id);
    List<T> findAll();
}