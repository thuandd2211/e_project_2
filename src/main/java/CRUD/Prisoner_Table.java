/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

/**
 *
 * @author DELL
 */
public class Prisoner_Table {

//    int id;
//    String rollNo;
//    String room;
//    String identify_number;
//    String fullname;
//    String gender;
//    String dob;
//    String place;
//    int height;
//    int weight;
//    String execution_date;
//    String release_date;
//    String status;
    
    Prisoner prisoner;
    Identify identify;
    room room;

    public Prisoner_Table() {
    }

//    public Prisoner_Table(int id, String rollNo, String room, String identify_number, String fullname, String gender, String dob, String place, int height, int weight, String execution_date, String release_date, String status) {
//        this.id = id;
//        this.rollNo = rollNo;
//        this.room = room;
//        this.identify_number = identify_number;
//        this.fullname = fullname;
//        this.gender = gender;
//        this.dob = dob;
//        this.place = place;
//        this.height = height;
//        this.weight = weight;
//        this.execution_date = execution_date;
//        this.release_date = release_date;
//        this.status = status;
//    }

    public Prisoner_Table(Prisoner prisoner, Identify identify, room room) {
        this.prisoner = prisoner;
        this.identify = identify;
        this.room = room;
    }



//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//    public String getRollNo() {
//        return rollNo;
//    }
//
//    public void setRollNo(String rollNo) {
//        this.rollNo = rollNo;
//    }
//
//    public String getRoom() {
//        return room;
//    }
//
//    public void setRoom(String room) {
//        this.room = room;
//    }
//
//    public String getIdentify_number() {
//        return identify_number;
//    }
//
//    public void setIdentify_number(String identify_number) {
//        this.identify_number = identify_number;
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public void setFullname(String fullname) {
//        this.fullname = fullname;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getPlace() {
//        return place;
//    }
//
//    public void setPlace(String place) {
//        this.place = place;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//    public String getExecution_date() {
//        return execution_date;
//    }
//
//    public void setExecution_date(String execution_date) {
//        this.execution_date = execution_date;
//    }
//
//    public String getRelease_date() {
//        return release_date;
//    }
//
//    public void setRelease_date(String release_date) {
//        this.release_date = release_date;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public Prisoner getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    public Identify getIdentify() {
        return identify;
    }

    public void setIdentify(Identify identify) {
        this.identify = identify;
    }

    public room getRoom() {
        return room;
    }

    public void setRoom(room room) {
        this.room = room;
    }

}
