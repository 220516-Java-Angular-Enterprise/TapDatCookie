package com.revature.cookieTap.services;

import com.revature.cookieTap.models.Level1;
import com.revature.cookieTap.models.Level2;

import java.util.List;

public class Level2Service {
private final com.revature.cookieTap.daos.level2DAO level2DAO;

    public Level2Service(com.revature.cookieTap.daos.level2DAO level2DAO) {
        this.level2DAO = level2DAO;
    }

    public List<Level2> getAll(){
        List<Level2> ones = level2DAO.getAll();
        return ones;
    }

    public List<Level2> getAllByUserID(String id){
        List<Level2> ones = level2DAO.getAllByUserID(id);
        return ones;
    }


}
