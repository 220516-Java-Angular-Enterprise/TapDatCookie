package com.revature.cookieTap.services;

import com.revature.cookieTap.models.Level3;

import java.util.List;

public class Level3Service {
    private final com.revature.cookieTap.daos.level3DAO level3DAO;

    public Level3Service(com.revature.cookieTap.daos.level3DAO level3DAO) {
        this.level3DAO = level3DAO;
    }
    public List<Level3> getAll(){
        List<Level3> ones = level3DAO.getAll();
        return ones;
    }

    public List<Level3> getAllByUserID(String id){
        List<Level3> ones = level3DAO.getAllByUserID(id);
        return ones;
    }
}
