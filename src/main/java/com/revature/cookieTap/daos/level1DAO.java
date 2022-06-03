package com.revature.cookieTap.daos;
import com.revature.cookieTap.models.Level1;
import com.revature.cookieTap.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class level1DAO implements CrudeDAO<Level1> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Level1 obj) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO level1 (id, user_id, score, time, date) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getUserId());
            ps.setInt(3, obj.getScore());
            ps.setDouble(4, obj.getTime());
            ps.setString(5, obj.getDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void update(Level1 Obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Level1 getByID(String id) {
        return null;
    }

    @Override
    public List<Level1> getAll() {
        List<Level1> ones = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM level1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Level1 one = new Level1(
                        rs.getString("id"),
                        rs.getString("user_id"),
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
    public List<Level1> getAllByUserID(String id) {
        List<Level1> ones = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM level1 WHERE user_id='"+id+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Level1 one = new Level1(
                        rs.getString("id"),
                        rs.getString("user_id"),
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
