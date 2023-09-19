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
public class Identify_CRUD extends BaseCRUD {

    public static List<Identify> getList() {
        List<Identify> dataList = new ArrayList<>();
        connect();
        String sql = "select * from identify";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Identify i = new Identify(
                        resultSet.getInt("id"),
                        resultSet.getString("identify_number"),
                        resultSet.getString("fullname"),
                        resultSet.getString("dob"),
                        resultSet.getString("native_place"),
                        resultSet.getString("place_of_permanent"));
                dataList.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Identify_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static List<Identify> findByID(int id) {
        List<Identify> dataList = new ArrayList<>();
        connect();
        String sql = "select * from identify where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Identify i = new Identify(
                        resultSet.getInt("id"),
                        resultSet.getString("identify_number"),
                        resultSet.getString("fullname"),
                        resultSet.getString("dob"),
                        resultSet.getString("native_place"),
                        resultSet.getString("place_of_permanent"));
                dataList.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Identify_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static List<Identify> findByIdentifyNumber(String number) {
        List<Identify> dataList = new ArrayList<>();
        connect();
        String sql = "select * from identify where identify_number = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, number);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Identify i = new Identify(
                        resultSet.getInt("id"),
                        resultSet.getString("identify_number"),
                        resultSet.getString("fullname"),
                        resultSet.getString("dob"),
                        resultSet.getString("native_place"),
                        resultSet.getString("place_of_permanent"));
                dataList.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Identify_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static void insert(Identify i) {
        connect();
        String sql = "insert into identify(identify_number, fullname, dob, native_place, place_of_permanent) values (?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, i.getIdentify_number());
            statement.setString(2, i.getFullname());
            statement.setString(3, i.getDob());
            statement.setString(4, i.getPlace());
            statement.setString(5, i.getAddress());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Identify_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public static void update(Identify i) {
        connect();
        String sql = "update identify set identify_number = ?, fullname = ?, dob = ? , "
                + "native_place = ? , place_of_permanent = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, i.getIdentify_number());
            statement.setString(2, i.getFullname());
            statement.setString(3, i.getDob());
            statement.setString(4, i.getPlace());
            statement.setString(5, i.getAddress());
            statement.setInt(6, i.getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Identify_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
    }

    public static void deleteByID(int id) {
        connect();
        String sql = "delete from identify where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
}
