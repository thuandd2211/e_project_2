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
public class room_CRUD extends BaseCRUD {

    public static List<room> getList() {
        List<room> dataList = new ArrayList<>();
        connect();
        String sql = "select * from room_name";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                room r = new room(
                        resultSet.getInt("id"),
                        resultSet.getString("room_name"));
                dataList.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(room_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static List<room> findByID(int id) {
        List<room> dataList = new ArrayList<>();
        connect();
        String sql = "select * from room_name where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                room r = new room(
                        resultSet.getInt("id"),
                        resultSet.getString("room_name"));
                dataList.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(room_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }
    
        public static List<room> findByRoomName(String room) {
        List<room> dataList = new ArrayList<>();
        connect();
        String sql = "select * from room_name where room_name = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, room);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                room r = new room(
                        resultSet.getInt("id"),
                        resultSet.getString("room_name"));
                dataList.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(room_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }
}
