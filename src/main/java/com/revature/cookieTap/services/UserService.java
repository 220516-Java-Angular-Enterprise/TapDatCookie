package com.revature.cookieTap.services;

import com.revature.cookieTap.models.User;

import java.util.List;

public class UserService {
    private final com.revature.cookieTap.daos.userDAO userDAO;

    public UserService(com.revature.cookieTap.daos.userDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean isDuplicateUser(String username){
        List<String> usernames = userDAO.getAllUsernames();

        if(usernames.contains(username)){
            return true;
        }
        return false;
    }

    public User getUserByUsername(String username){
        User user = userDAO.getByUsername(username);
        return user;
    }

    public void registerUser(User user){
        userDAO.save(user);
    }

    public void updateUser(User user){
        userDAO.update(user);
    }


}
