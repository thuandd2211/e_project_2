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
public class Crime_CRUD extends BaseCRUD {

    public static List<Crime> getList() {
        List<Crime> dataList = new ArrayList<>();
        connect();
        String sql = "select * from crime";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crime c = new Crime(
                        resultSet.getInt("id"),
                        resultSet.getString("crime_name"));
                dataList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
        return dataList;
    }

    public static List<Crime> findByCrime(String crime_name) {
        List<Crime> dataList = new ArrayList<>();
        connect();
        String sql = "select * from crime where crime_name = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, crime_name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crime c = new Crime(
                        resultSet.getInt("id"),
                        resultSet.getString("crime_name"));
                dataList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }
    
    public static List<Crime> findByID(int id) {
        List<Crime> dataList = new ArrayList<>();
        connect();
        String sql = "select * from crime where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crime c = new Crime(
                        resultSet.getInt("id"),
                        resultSet.getString("crime_name"));
                dataList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crime_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

}
