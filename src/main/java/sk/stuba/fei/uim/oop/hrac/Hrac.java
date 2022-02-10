package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.policko.Policko;

import java.util.ArrayList;

public class Hrac {
    public String name;
    public double peniaze = 10000.0;
    public int pozicia = 0;
    public ArrayList<Policko> vlastnictvo = new ArrayList<>();
    public boolean uvazneny = false;
    public int pocetKolVoVazbe;

    public int padlo(){
        return (int) (Math.random() * 6 + 1);
    }

    public Hrac(ArrayList<Policko> vlastnictvo) {
        this.vlastnictvo = vlastnictvo;

    }

    public ArrayList<Policko> getVlastnictvo() {
        return vlastnictvo;
    }

    public void setVlastnictvo(ArrayList<Policko> vlastnictvo) {
        this.vlastnictvo = vlastnictvo;
    }

    public Hrac(double peniaze) {
        this.peniaze = peniaze;
    }

    public Hrac(int pozicia) {
        this.pozicia = pozicia;
    }

    public Hrac(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPeniaze() {
        return peniaze;
    }

    public void setPeniaze(double peniaze) {
        this.peniaze = peniaze;
    }

    public int getPozicia() {
        return pozicia;
    }

    public void setPozicia(int pozicia) {
        this.pozicia = pozicia;
    }
}
