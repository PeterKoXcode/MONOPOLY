package sk.stuba.fei.uim.oop.sance;

import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class SancaZaplatitDane extends Sanca{
    private final double cenaDane = 2000.0;
    private int hracNaTahu;
    private Hraci hraci;

    @Override
    public void typSance(Hraci hraci, int hracNaTahu, HraciePole hraciePole, BalicekKariet balicekKariet) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        printSancaDane();
    }

    private void printSancaDane(){
        System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" si vytiahol šancu zaplatiť dane.");
        this.hraci.getPoleHracov().get(this.hracNaTahu-1).setPeniaze(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze()-this.cenaDane);
        if(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze() <= 0.0){
            System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" nemá dostatok financií a vypadáva z hry.");

            // odstranenie majetku


            this.hraci.getPoleHracov().remove(this.hraci.getPoleHracov().get(this.hracNaTahu-1));
        }
        else{
            System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" zaplatil daň 2000.0");
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
