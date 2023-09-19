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
public class Crime_type_CRUD extends BaseCRUD {

    public static List<Crime_type> getList() {
        List<Crime_type> dataList = new ArrayList<>();
        connect();
        String sql = "select * from crime_type";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crime_type c = new Crime_type(
                        resultSet.getInt("id"),
                        resultSet.getString("crime")
                );
                dataList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crime_type_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
        return dataList;
    }

    public static List<Crime_type> FindByID(int id) {
        List<Crime_type> dataList = new ArrayList<>();
        connect();
        String sql = "select * from crime_type where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crime_type c = new Crime_type(
                        resultSet.getInt("id"),
                        resultSet.getString("crime")
                );
                dataList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crime_type_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
        return dataList;
    }

        public static List<Crime_type> FindByName(String crime) {
        List<Crime_type> dataList = new ArrayList<>();
        connect();
        String sql = "select * from crime_type where crime = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, crime);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crime_type c = new Crime_type(
                        resultSet.getInt("id"),
                        resultSet.getString("crime")
                );
                dataList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crime_type_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
        return dataList;
    }
}
