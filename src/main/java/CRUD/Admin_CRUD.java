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
public class Admin_CRUD extends BaseCRUD{
    public static boolean getListByUserName(String user, String pass){
        connect();
        String sql = "select id, username, password, fullname from admin where username = ? and password = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return false;
    }
    
    public static List<Admin> findByUserName(String username){
        List<Admin> dataList = new ArrayList<>();
        connect();
        String sql = "select * from admin where username = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {                
                Admin a = new Admin(
                        resultSet.getInt("id"),
                        resultSet.getString("fullname"), 
                        resultSet.getString("password"),
                        resultSet.getString("fullname"));
                dataList.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        disconnect();
        return dataList;
    }
}
