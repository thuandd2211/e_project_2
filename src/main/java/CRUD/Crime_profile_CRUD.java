/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 *
 * @author DELL
 */
public class Crime_profile_CRUD extends BaseCRUD {

    public static ObservableList<Crime_profile> getList() {
        ObservableList<Crime_profile> dataList = FXCollections.observableArrayList();
        connect();
        String sql = "select * from crime_profile join crime_type on crime_profile.crime_type_id = crime_type.id";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crime_profile c = new Crime_profile(
                        resultSet.getInt("crime_profile.id"),
                        resultSet.getInt("crime_profile.crime_type_id"),
                        resultSet.getInt("crime_profile.number_of_criminal"),
                        resultSet.getString("crime_profile.actual_date"),
                        resultSet.getString("crime_profile.note"));
                dataList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crime_profile_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static ObservableList<Crime_profile> findByCrime_Proflie_ID(int id) {
        ObservableList<Crime_profile> dataList = FXCollections.observableArrayList();
        connect();
        String sql = "select * from crime_profile join crime_type on crime_profile.crime_type_id = crime_type.id and crime_profile.id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crime_profile c = new Crime_profile(
                        resultSet.getInt("crime_profile.id"),
                        resultSet.getInt("crime_profile.crime_type_id"),
                        resultSet.getInt("crime_profile.number_of_criminal"),
                        resultSet.getString("crime_profile.actual_date"),
                        resultSet.getString("crime_profile.note"));
                dataList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crime_profile_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

//    public static ObservableList<Crime_type> findByCrime_type_ID(int id) {
//        ObservableList<Crime_type> dataList = FXCollections.observableArrayList();
//        connect();
//        String sql = "select * from crime_type where id = ?";
//        try {
//            statement = conn.prepareStatement(sql);
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Crime_type c = new Crime_type(
//                        resultSet.getInt("id"),
//                        resultSet.getString("crime"));
//                dataList.add(c);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Crime_profile_CRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        disconnect();
//        return dataList;
//    }
    public static ObservableList<Crime_profile> findByCrime_type(String crime) {
        ObservableList<Crime_profile> dataList = FXCollections.observableArrayList();
        connect();
        String sql = "select * from crime_profile join crime_type on crime_profile.crime_type_id = crime_type.id and crime_type.crime = ?";
        try {

            statement = conn.prepareStatement(sql);
            statement.setString(1, crime);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crime_profile c = new Crime_profile(
                        resultSet.getInt("crime_profile.id"),
                        resultSet.getInt("crime_profile.crime_type_id"),
                        resultSet.getInt("crime_profile.number_of_criminal"),
                        resultSet.getString("crime_profile.actual_date"),
                        resultSet.getString("crime_profile.note"));
                dataList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crime_profile_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static void insert(Crime_profile crime) {
        connect();

        String sql = "insert into crime_profile(crime_type_id,number_of_criminal,actual_date,note) values (?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, crime.getCrime_type());
            statement.setInt(2, crime.getNumber());
            statement.setString(3, crime.getDate());
            statement.setString(4, crime.getNote());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Crime_profile_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public static void update(Crime_profile crime) {
        connect();
        String sql = "update crime_profile set crime_type_id = ?, number_of_criminal = ?, actual_date = ?, note = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, crime.getCrime_type());
            statement.setInt(2, crime.getNumber());
            statement.setString(3, crime.getDate());
            statement.setString(4, crime.getNote());
            statement.setInt(5, crime.getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Crime_profile_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
    }

    public static void deleteByCrime_Profile_ID(int id) {
        connect();
        String sql = "delete from crime_profile where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Crime_profile_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public static void update_numberOfCriminal(Crime_profile c) {
        connect();
        String sql = "update crime_profile set number_of_criminal = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, c.getNumber() + 1);
            statement.setInt(2, c.getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Crime_profile_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public static void update_numberOfCriminal_decrease(int id, int number) {
        connect();
        String sql = "update crime_profile set number_of_criminal = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, number - 1);
            statement.setInt(2, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Crime_profile_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    

    public static List<Crime_profile> getListByDay(String fisrt_day, String last_date) {
        List<Crime_profile> dataList = new ArrayList<>();
        connect();
        String sql = "select * from crime_profile where actual_date >= ? and actual_date <= ?;";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, fisrt_day);
            statement.setString(2, last_date);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Crime_profile c = new Crime_profile(
                        resultSet.getInt("crime_profile.id"),
                        resultSet.getInt("crime_profile.crime_type_id"),
                        resultSet.getInt("crime_profile.number_of_criminal"),
                        resultSet.getString("crime_profile.actual_date"),
                        resultSet.getString("crime_profile.note"));
                dataList.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crime_profile_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    } 
}
