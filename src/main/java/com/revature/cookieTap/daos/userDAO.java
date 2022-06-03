package com.revature.cookieTap.daos;

import com.revature.cookieTap.models.User;
import com.revature.cookieTap.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDAO implements CrudeDAO<User>{
    Connection con = DatabaseConnection.getCon();
    @Override
    public void save(User obj) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (id, username, one_id, two_id, three_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getOneId());
            ps.setString(4, obj.getTwoId());
            ps.setString(5, obj.getThreeId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void update(User Obj) {
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE users SET " +
                    "username = '" + Obj.getUsername() + "'," +
                    "one_id = '" + Obj.getOneId() + "'," +
                    "two_id = '" + Obj.getTwoId() + "'," +
                    "three_id = '" + Obj.getThreeId() + "'," +
                    "WHERE id = '" + Obj.getId() + "';");
            ps.executeUpdate();
        }   catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User getByID(String id) {
        return null;
    }

    public User getByUsername(String username){
        User user = new User();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username ='"+username+"';");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User us = new User(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("one_id"),
                        rs.getString("two_id"),
                        rs.getString("three_id")
                );
                user = us;
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("one_id"),
                        rs.getString("two_id"),
                        rs.getString("three_id")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return users;
    }
    public List<String> getAllUsernames() {
        List<String> usernames = new ArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT username FROM users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usernames.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return usernames;
    }

}
