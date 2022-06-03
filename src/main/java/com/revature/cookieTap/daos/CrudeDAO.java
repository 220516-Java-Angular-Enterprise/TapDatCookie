package com.revature.cookieTap.daos;

import java.util.List;

public interface CrudeDAO<T>{
    void save (T obj);
    void update(T Obj);
    void delete(String id);

    T getByID(String id);
    List<T> getAll();

}