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
public class statistic_Prisoner {

    List<Prisoner> prisoner_in;
    List<Prisoner> prisoner_out;
    List<Prisoner> prisoner;

    public statistic_Prisoner() {
    }

    public statistic_Prisoner(List<Prisoner> prisoner_in, List<Prisoner> prisoner_out, List<Prisoner> prisoner) {
        this.prisoner_in = prisoner_in;
        this.prisoner_out = prisoner_out;
        this.prisoner = prisoner;
    }

    public List<Prisoner> getPrisoner_in() {
        return prisoner_in;
    }

    public void setPrisoner_in(List<Prisoner> prisoner_in) {
        this.prisoner_in = prisoner_in;
    }

    public List<Prisoner> getPrisoner_out() {
        return prisoner_out;
    }

    public void setPrisoner_out(List<Prisoner> prisoner_out) {
        this.prisoner_out = prisoner_out;
    }

    public List<Prisoner> getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(List<Prisoner> prisoner) {
        this.prisoner = prisoner;
    }

}
