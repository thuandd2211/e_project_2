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
public class statistic_Crime {
    Crime crime;
    List<Crime_profile> crime_profile;

    public statistic_Crime() {
    }

    public statistic_Crime(Crime crime, List<Crime_profile> crime_profile) {
        this.crime = crime;
        this.crime_profile = crime_profile;
    }

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }

    public List<Crime_profile> getCrime_profile() {
        return crime_profile;
    }

    public void setCrime_profile(List<Crime_profile> crime_profile) {
        this.crime_profile = crime_profile;
    }
    
}
