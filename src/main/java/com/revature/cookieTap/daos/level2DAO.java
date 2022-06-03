package com.revature.cookieTap.daos;

import com.revature.cookieTap.models.Level1;
import com.revature.cookieTap.models.Level2;
import com.revature.cookieTap.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class level2DAO implements CrudeDAO<Level2>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Level2 obj) {

    }

    @Override
    public void update(Level2 Obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Level2 getByID(String id) {
        return null;
    }

    @Override
    public List<Level2> getAll() {
        List<Level2> twos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM level2");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Level2 two = new Level2(
                        rs.getString("id"),
                        rs.getString("userId"),
                        rs.getInt("score"),
                        rs.getDouble("time"),
                        rs.getString("date")
                );
                twos.add(two);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return twos;
    }

    public List<Level2> getAllByUserID(String id) {
        List<Level2> ones = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM level2 WHERE user_id='"+id+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Level2 one = new Level2(
                        rs.getString("id"),
                        rs.getString("userId"),
                        rs.getInt("score"),
                        rs.getDouble("time"),
                        rs.getString("date")
                );
                ones.add(one);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return ones;
    }
}
