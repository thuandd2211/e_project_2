/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Has_crime_CRUD extends BaseCRUD {

    public static List<Has_crime> getList() {
        List<Has_crime> dataList = new ArrayList<>();
        connect();
        String sql = "select * from has_crime";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Has_crime h = new Has_crime(
                        resultSet.getInt("id"),
                        resultSet.getInt("crime_id"),
                        resultSet.getInt("prisoner_id"),
                        resultSet.getInt("crime_profile_id"));
                dataList.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Has_crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static List<Has_crime> getList_by_crime_profile_id(int id) {
        List<Has_crime> dataList = new ArrayList<>();
        connect();
        String sql = "select * from has_crime where crime_profile_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Has_crime h = new Has_crime(
                        resultSet.getInt("id"),
                        resultSet.getInt("crime_id"),
                        resultSet.getInt("prisoner_id"),
                        resultSet.getInt("crime_profile_id"));
                dataList.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Has_crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static List<Has_crime> getList_by_crime_profile_id_by_prisoner_id(int crime_profile_id, int prisoner_id) {
        List<Has_crime> dataList = new ArrayList<>();
        connect();
        String sql = "select * from has_crime where crime_profile_id = ? and prisoner_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, crime_profile_id);
            statement.setInt(2, prisoner_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Has_crime h = new Has_crime(
                        resultSet.getInt("id"),
                        resultSet.getInt("crime_id"),
                        resultSet.getInt("prisoner_id"),
                        resultSet.getInt("crime_profile_id"));
                dataList.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Has_crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static List<Has_crime> getList_by_prisoner_id(int id) {
        List<Has_crime> dataList = new ArrayList<>();
        connect();
        String sql = "select * from has_crime where prisoner_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Has_crime h = new Has_crime(
                        resultSet.getInt("id"),
                        resultSet.getInt("crime_id"),
                        resultSet.getInt("prisoner_id"),
                        resultSet.getInt("crime_profile_id"));
                dataList.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Has_crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static List<Has_crime> getList_by_crime_id(int id) {
        List<Has_crime> dataList = new ArrayList<>();
        connect();
        String sql = "select * from has_crime where crime_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Has_crime h = new Has_crime(
                        resultSet.getInt("id"),
                        resultSet.getInt("crime_id"),
                        resultSet.getInt("prisoner_id"),
                        resultSet.getInt("crime_profile_id"));
                dataList.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Has_crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static void delete_by_crime_profile(int id) {
        connect();
        String sql = "delete from has_crime where crime_profile_id = ? ";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Has_crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
    }

    public static void insert(Has_crime c) {
        connect();
        String sql = "insert into has_crime(crime_id,prisoner_id,crime_profile_id) value (?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, c.getCrime_id());
            statement.setInt(2, c.getPrisoner_id());
            statement.setInt(3, c.getCrime_profile_id());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Has_crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public static void deleteByID(int id) {
        connect();
        String sql = "delete from has_crime where id = ? ";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Has_crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
    }
    
    public static void updateByCrime_profile_id(Has_crime h){
        connect();
        String sql = "update has_crime set crime_id = ?, crime_profile_id = ?, prisoner_id = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, h.getCrime_id());
            statement.setInt(2, h.getCrime_profile_id());
            statement.setInt(3, h.prisoner_id);
            statement.setInt(4, h.getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Has_crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    
}
