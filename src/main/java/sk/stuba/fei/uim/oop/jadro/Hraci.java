package sk.stuba.fei.uim.oop.jadro;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;

public class Hraci {
    private int pocetHracov = 0;
    private ArrayList<Hrac> poleHracov;

    public Hraci() {
        setHraci();
    }

    public ArrayList<Hrac> getPoleHracov() {
        return this.poleHracov;
    }

    public void setPoleHracov(ArrayList<Hrac> poleHracov) {
        this.poleHracov = poleHracov;
    }

    private void setHraci() {
        this.pocetHracov = nacitanieHracov(this.pocetHracov);
        System.out.println(this.pocetHracov);
        this.poleHracov = new ArrayList<>();
        for(int i = 0; i < this.pocetHracov; i++){
            String meno = KeyboardInput.readString("Zadajte meno "+ (i+1) +". hráča");
            this.poleHracov.add(new Hrac(meno));
        }
        for(Hrac hrac : this.poleHracov){
            System.out.println(hrac.getName());
        }
    }
    private int nacitanieHracov(int pocet){
        pocet = KeyboardInput.readInt("Zadajte počet hráčov (2-6)");
        if(pocet < 2 || pocet > 6){
            System.out.println("Nebol zadaný správny typ parametra. Zadajte celé číslo v intervale od 2 po 6.");
            return nacitanieHracov(pocet);
        }
        return  pocet;
    }
}
