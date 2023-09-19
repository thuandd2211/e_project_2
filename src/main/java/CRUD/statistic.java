/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

/**
 *
 * @author DELL
 */
public class statistic {
    statistic_Crime crime;
    statistic_Crime_type crime_type;
    statistic_Prisoner prisoner;

    public statistic() {
    }

    public statistic(statistic_Crime crime, statistic_Crime_type crime_type, statistic_Prisoner prisoner) {
        this.crime = crime;
        this.crime_type = crime_type;
        this.prisoner = prisoner;
    }

    public statistic_Crime getCrime() {
        return crime;
    }

    public void setCrime(statistic_Crime crime) {
        this.crime = crime;
    }

    public statistic_Crime_type getCrime_type() {
        return crime_type;
    }

    public void setCrime_type(statistic_Crime_type crime_type) {
        this.crime_type = crime_type;
    }

    public statistic_Prisoner getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(statistic_Prisoner prisoner) {
        this.prisoner = prisoner;
    }
    
}
