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
public class Crime_profile_CRUD extends BaseCRUD{
    public static ObservableList<Crime_profile> getList(){
        ObservableList<Crime_profile> dataList = FXCollections.observableArrayList();
        connect();
        String sql = "select * from crime_profile join crime_type on crime_profile.crime_type_id = crime_type.id";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
//                String crime_type = resultSet.getString("crime_type.crime");
                Crime_profile c = new Crime_profile(
                        resultSet.getInt("crime_profile.id"),
                        resultSet.getString("crime_type.crime"),
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
    public static ObservableList<Crime_profile> findByCrime_type(String crime){
        ObservableList<Crime_profile> dataList = FXCollections.observableArrayList();
        connect();
        String sql = "select * from crime_profile join crime_type on crime_profile.crime_type_id = crime_type.id where crime_type.crime = crime";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Crime_profile c = new Crime_profile(
                        resultSet.getInt("crime_profile.id"),
                        resultSet.getString("crime_type.crime"),
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
