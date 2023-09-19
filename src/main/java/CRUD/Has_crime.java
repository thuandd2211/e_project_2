/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

/**
 *
 * @author DELL
 */
public class Has_crime {

    int id;
    int crime_id;
    int prisoner_id;
    int crime_profile_id;

    public Has_crime() {
    }

    public Has_crime(int id, int crime_id, int prisoner_id, int crime_profile_id) {
        this.id = id;
        this.crime_id = crime_id;
        this.prisoner_id = prisoner_id;
        this.crime_profile_id = crime_profile_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCrime_id() {
        return crime_id;
    }

    public void setCrime_id(int crime_id) {
        this.crime_id = crime_id;
    }

    public int getPrisoner_id() {
        return prisoner_id;
    }

    public void setPrisoner_id(int prisoner_id) {
        this.prisoner_id = prisoner_id;
    }

    public int getCrime_profile_id() {
        return crime_profile_id;
    }

    public void setCrime_profile_id(int crime_profile_id) {
        this.crime_profile_id = crime_profile_id;
    }

}
