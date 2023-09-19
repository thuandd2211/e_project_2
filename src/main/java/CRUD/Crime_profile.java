/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

/**
 *
 * @author DELL
 */
public class Crime_profile {
    int id;
    int crime_type;
    int number;
    String date;
    String note;

    public Crime_profile() {
    }

    public Crime_profile(int id, int crime_type, int number, String date, String note) {
        this.id = id;
        this.crime_type = crime_type;
        this.number = number;
        this.date = date;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCrime_type() {
        return crime_type;
    }

    public void setCrime_type(int crime_type) {
        this.crime_type = crime_type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    
}
