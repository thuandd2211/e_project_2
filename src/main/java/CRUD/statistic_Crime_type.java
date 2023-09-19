/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import java.util.List;

/**
 *
 * @author DELL
 */
public class statistic_Crime_type {
    Crime_type crime_type;
    List<Crime_profile> crime_profile;

    public statistic_Crime_type() {
    }

    public statistic_Crime_type(Crime_type crime_type, List<Crime_profile> crime_profile) {
        this.crime_type = crime_type;
        this.crime_profile = crime_profile;
    }

    public Crime_type getCrime_type() {
        return crime_type;
    }

    public void setCrime_type(Crime_type crime_type) {
        this.crime_type = crime_type;
    }

    public List<Crime_profile> getCrime_profile() {
        return crime_profile;
    }

    public void setCrime_profile(List<Crime_profile> crime_profile) {
        this.crime_profile = crime_profile;
    }
    
}
