/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

/**
 *
 * @author DELL
 */
public class Prisoner {
    int id;
    String roll_no;
    String fullname;
    String gender;
    int height;
    int weight;
    int identify_id;
    String execution_date;
    String release_date;
    int room_id;
    String note;
    String status;

    public Prisoner() {
    }

    public Prisoner(int id, String roll_no, String fullname, String gender, int height, int weight, int identify_id, String execution_date, String release_date, int room_id, String note, String status) {
        this.id = id;
        this.roll_no = roll_no;
        this.fullname = fullname;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.identify_id = identify_id;
        this.execution_date = execution_date;
        this.release_date = release_date;
        this.room_id = room_id;
        this.note = note;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getIdentify_id() {
        return identify_id;
    }

    public void setIdentify_id(int identify_id) {
        this.identify_id = identify_id;
    }

    public String getExecution_date() {
        return execution_date;
    }

    public void setExecution_date(String execution_date) {
        this.execution_date = execution_date;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Prisoner{" + "id=" + id + ", roll_no=" + roll_no + ", fullname=" + fullname + ", gender=" + gender + ", height=" + height + ", weight=" + weight + ", identify_id=" + identify_id + ", execution_date=" + execution_date + ", release_date=" + release_date + ", room_id=" + room_id + ", note=" + note + ", status=" + status + '}';
    }
    
}
