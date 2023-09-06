/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import com.mycompany.e_project_2.App;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.net.ConnectException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author DELL
 */
public class BaseCRUD {
    static final String DB_NAME = "criminal_management";
    static final String DB_USERNAME = "root";
    static final String DB_PWD = "12345678";
    static Connection conn = null;
    static PreparedStatement statement = null;
    
    static void connect(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_USERNAME, DB_PWD);
        } catch (SQLException ex) {
            Logger.getLogger(BaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void disconnect(){
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

