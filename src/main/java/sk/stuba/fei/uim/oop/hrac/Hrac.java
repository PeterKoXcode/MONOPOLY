package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.policko.Policko;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Hrac {
    private String name;
    private double peniaze = 10000.0;
    private int pozicia = 0;
    private List<Integer> vlastnictvo2 = new ArrayList<>();
    private ArrayList<Policko> vlastnictvo = new ArrayList<>();
    private boolean uvazneny = false;
    private int pocetKolVoVazbe = 0;

    public int padlo(){
        return (int) (Math.random() * 6 + 1);
    }

    public List<Integer> getVlastnictvo2() {
        return vlastnictvo2;
    }

    public void setVlastnictvo2(List<Integer> vlastnictvo2) {
        this.vlastnictvo2 = vlastnictvo2;
    }

    public Hrac(ArrayList<Policko> vlastnictvo) {
        this.vlastnictvo = vlastnictvo;

    }

    public ArrayList<Policko> getVlastnictvo() {
        return this.vlastnictvo;
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

    public boolean isUvazneny() {
        return uvazneny;
    }

    public void setUvazneny(boolean uvazneny) {
        this.uvazneny = uvazneny;
    }

    public int getPocetKolVoVazbe() {
        return pocetKolVoVazbe;
    }

    public void setPocetKolVoVazbe(int pocetKolVoVazbe) {
        this.pocetKolVoVazbe = pocetKolVoVazbe;
    }
}
