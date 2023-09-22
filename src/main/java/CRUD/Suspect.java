/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

/**
 *
 * @author DELL
 */
public class Suspect {
    Crime_profile crime_profile;
    Crime crime;
    Prisoner prisoner;

    public Suspect() {
    }

    public Suspect(Crime_profile crime_profile, Crime crime, Prisoner prisoner) {
        this.crime_profile = crime_profile;
        this.crime = crime;
        this.prisoner = prisoner;
    }

    public Crime_profile getCrime_profile() {
        return crime_profile;
    }

    public void setCrime_profile(Crime_profile crime_profile) {
        this.crime_profile = crime_profile;
    }

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }

    public Prisoner getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(Prisoner prisoner) {
        this.prisoner = prisoner;
    }
    
    
}
