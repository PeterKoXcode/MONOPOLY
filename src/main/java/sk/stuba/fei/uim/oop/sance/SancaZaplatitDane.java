package sk.stuba.fei.uim.oop.sance;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class SancaZaplatitDane extends Sanca{
    private final double cenaDane = 2000.0;
    private int hracNaTahu;
    private Hraci hraci;
    private HraciePole hraciePole;

    @Override
    public void typSance(Hraci hraci, int hracNaTahu, HraciePole hraciePole, BalicekKariet balicekKariet) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        this.hraciePole = hraciePole;
        printSancaDane();
    }

    private void printSancaDane(){
        Hrac currentPlayer = this.hraci.getPoleHracov().get(this.hracNaTahu-1);
        System.out.println(currentPlayer.getName()+" si vytiahol šancu zaplatiť dane.");
        currentPlayer.setPeniaze(currentPlayer.getPeniaze()-this.cenaDane);
        if(currentPlayer.getPeniaze() <= 0.0){
            System.out.println(currentPlayer.getName()+" nemá dostatok financií a vypadáva z hry.");

            // odstranenie majetku
            this.hraciePole.removeProperty(currentPlayer);


            this.hraci.getPoleHracov().remove(currentPlayer);
        }
        else{
            System.out.println(currentPlayer.getName()+" zaplatil daň 2000.0");
        }
    }

    public int getHracNaTahu() {
        return hracNaTahu;
    }

    public void setHracNaTahu(int hracNaTahu) {
        this.hracNaTahu = hracNaTahu;
    }

    public Hraci getHraci() {
        return hraci;
    }

    public void setHraci(Hraci hraci) {
        this.hraci = hraci;
    }
}
