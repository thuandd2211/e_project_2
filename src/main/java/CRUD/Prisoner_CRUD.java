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
public class Prisoner_CRUD extends BaseCRUD {

    public static List<Prisoner> getList() {
        List<Prisoner> dataList = new ArrayList<>();
        connect();
        String sql = "select * from prisoner";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Prisoner p = new Prisoner(
                        resultSet.getInt("id"),
                        resultSet.getString("roll_no"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getInt("height"),
                        resultSet.getInt("weight"),
                        resultSet.getInt("identify_id"),
                        resultSet.getString("execution_date"),
                        resultSet.getString("release_date"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("note"),
                        resultSet.getString("status"));
                dataList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static List<Prisoner> findByRollno(String rollNo) {
        List<Prisoner> dataList = new ArrayList<>();
        connect();
        String sql = "select * from prisoner where roll_no = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, rollNo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Prisoner p = new Prisoner(
                        resultSet.getInt("id"),
                        resultSet.getString("roll_no"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getInt("height"),
                        resultSet.getInt("height"),
                        resultSet.getInt("identify_id"),
                        resultSet.getString("execution_date"),
                        resultSet.getString("release_date"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("note"),
                        resultSet.getString("status"));
                dataList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
        return dataList;
    }

    public static List<Prisoner> findByID(int id) {
        List<Prisoner> dataList = new ArrayList<>();
        connect();
        String sql = "select * from prisoner where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Prisoner p = new Prisoner(
                        resultSet.getInt("id"),
                        resultSet.getString("roll_no"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getInt("height"),
                        resultSet.getInt("height"),
                        resultSet.getInt("identify_id"),
                        resultSet.getString("execution_date"),
                        resultSet.getString("release_date"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("note"),
                        resultSet.getString("status"));
                dataList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
        return dataList;
    }

    public static List<Prisoner> findByName(String name) {
        List<Prisoner> dataList = new ArrayList<>();
        connect();
        String sql = "select * from prisoner where fullname = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Prisoner p = new Prisoner(
                        resultSet.getInt("id"),
                        resultSet.getString("roll_no"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getInt("height"),
                        resultSet.getInt("height"),
                        resultSet.getInt("identify_id"),
                        resultSet.getString("execution_date"),
                        resultSet.getString("release_date"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("note"),
                        resultSet.getString("status"));
                dataList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
        return dataList;
    }

//    public static List<Prisoner_Table> getTableList() {
//        List<Prisoner_Table> dataList = new ArrayList<>();
//        connect();
//        String sql = "select prisoner.id, prisoner.roll_no, room_name.room_name, identify.identify_number, prisoner.fullname, prisoner.gender, identify.dob, identify.native_place, "
//                + "prisoner.height, prisoner.weight, prisoner.execution_date, prisoner.release_date, prisoner.status from prisoner "
//                + "join identify on identify.id = prisoner.identify_id "
//                + "join room_name on room_name.id = prisoner.room_id";
//        try {
//            statement = conn.prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Prisoner_Table p = new Prisoner_Table(
//                        resultSet.getInt("prisoner.id"),
//                        resultSet.getString("prisoner.roll_no"),
//                        resultSet.getString("room_name.room_name"),
//                        resultSet.getString("identify.identify_number"),
//                        resultSet.getString("prisoner.fullname"),
//                        resultSet.getString("prisoner.gender"),
//                        resultSet.getString("identify.dob"),
//                        resultSet.getString("identify.native_place"),
//                        resultSet.getInt("prisoner.height"),
//                        resultSet.getInt("prisoner.weight"),
//                        resultSet.getString("prisoner.execution_date"),
//                        resultSet.getString("prisoner.release_date"),
//                        resultSet.getString("prisoner.status"));
//                dataList.add(p);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        disconnect();
//        return dataList;
//    }
    public static void insert(Prisoner p) {
        connect();
        String sql = "insert into prisoner(roll_no, fullname, gender, height, weight, identify_id, execution_date, "
                + "release_date, room_id, note, status) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, p.getRoll_no());
            statement.setString(2, p.getFullname());
            statement.setString(3, p.getGender());
            statement.setInt(4, p.getHeight());
            statement.setInt(5, p.getWeight());
            statement.setInt(6, p.getIdentify_id());
            statement.setString(7, p.getExecution_date());
            statement.setString(8, p.getRelease_date());
            statement.setInt(9, p.getRoom_id());
            statement.setString(10, p.getNote());
            statement.setString(11, p.getStatus());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public static void update(Prisoner p) {
        connect();
        String sql = "update prisoner set roll_no = ?, fullname = ?, gender = ?, height = ?, weight = ?, "
                + "identify_id = ?, execution_date = ? , release_date = ? , "
                + "room_id = ? , note = ? , status = ? where id = ? ";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, p.getRoll_no());
            statement.setString(2, p.getFullname());
            statement.setString(3, p.getGender());
            statement.setInt(4, p.getHeight());
            statement.setInt(5, p.getWeight());
            statement.setInt(6, p.getIdentify_id());
            statement.setString(7, p.getExecution_date());
            statement.setString(8, p.getRelease_date());
            statement.setInt(9, p.getRoom_id());
            statement.setString(10, p.getNote());
            statement.setString(11, p.getStatus());
            statement.setInt(12, p.getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public static void deleteByID(int id) {
        connect();
        String sql = "delete from prisoner where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public static List<Prisoner> getListInByDay(String firstDate, String lastDate) {
        List<Prisoner> dataList = new ArrayList<>();
        connect();
        String sql = "select * from prisoner where execution_date = ? and execution_date = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, firstDate);
            statement.setString(2, lastDate);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Prisoner p = new Prisoner(
                        resultSet.getInt("id"),
                        resultSet.getString("roll_no"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getInt("height"),
                        resultSet.getInt("height"),
                        resultSet.getInt("identify_id"),
                        resultSet.getString("execution_date"),
                        resultSet.getString("release_date"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("note"),
                        resultSet.getString("status"));
                dataList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static List<Prisoner> getListOutByDay(String firstDate, String lastDate) {
        List<Prisoner> dataList = new ArrayList<>();
        connect();
        String sql = "select * from prisoner where release_date = ? and release_date = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, firstDate);
            statement.setString(2, lastDate);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Prisoner p = new Prisoner(
                        resultSet.getInt("id"),
                        resultSet.getString("roll_no"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getInt("height"),
                        resultSet.getInt("height"),
                        resultSet.getInt("identify_id"),
                        resultSet.getString("execution_date"),
                        resultSet.getString("release_date"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("note"),
                        resultSet.getString("status"));
                dataList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return dataList;
    }

    public static List<Prisoner> findByStatus() {
        List<Prisoner> dataList = new ArrayList<>();
        connect();
        String sql = "select * from prisoner where status = 'Đang thụ án'";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Prisoner p = new Prisoner(
                        resultSet.getInt("id"),
                        resultSet.getString("roll_no"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getInt("height"),
                        resultSet.getInt("height"),
                        resultSet.getInt("identify_id"),
                        resultSet.getString("execution_date"),
                        resultSet.getString("release_date"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("note"),
                        resultSet.getString("status"));
                dataList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prisoner_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnect();
        return dataList;
    }
}
