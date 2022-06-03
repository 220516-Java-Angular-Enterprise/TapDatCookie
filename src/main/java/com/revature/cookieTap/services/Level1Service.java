package com.revature.cookieTap.services;

import com.revature.cookieTap.models.Level1;

import java.util.List;

public class Level1Service {
    private final com.revature.cookieTap.daos.level1DAO level1DAO;

    public Level1Service(com.revature.cookieTap.daos.level1DAO level1DAO) {
        this.level1DAO = level1DAO;
    }

    public List<Level1> getAll(){
        List<Level1> ones = level1DAO.getAll();
        return ones;
    }

    public List<Level1> getAllByUserID(String id){
        List<Level1> ones = level1DAO.getAllByUserID(id);
        return ones;
    }

    public void register(Level1 one){
        level1DAO.save(one);
    }
}
