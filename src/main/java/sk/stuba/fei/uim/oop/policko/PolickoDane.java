package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class PolickoDane extends Policko{
    private final double cenaDane = 2000.0;
    private int hracNaTahu;
    private Hraci hraci;
    private HraciePole hraciePole;

    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu, BalicekKariet balicekKariet, HraciePole hraciePole) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        this.hraciePole = hraciePole;
        printDane();
    }


    public PolickoDane(){}

    private void printDane(){
        this.hraci.getPoleHracov().get(this.hracNaTahu-1).setPeniaze(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze()-this.cenaDane);
        if(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze() <= 0.0){
            System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" nemá dostatok financií a vypadáva z hry.");

            // odstranenie majetku
            for(int i = 0; i < this.hraciePole.getHraciePole().size(); i++){

            }


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
