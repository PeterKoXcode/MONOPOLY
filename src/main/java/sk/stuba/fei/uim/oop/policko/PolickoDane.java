package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.jadro.Hraci;

public class PolickoDane extends Policko{
    private final double cenaDane = 2000.0;
    private int hracNaTahu;
    private Hraci hraci;

    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        printDane();
    }

    public PolickoDane(){}

    private void printDane(){
        this.hraci.getPoleHracov().get(hracNaTahu-1).setPeniaze(this.hraci.getPoleHracov().get(hracNaTahu-1).getPeniaze()-cenaDane);
        if(this.hraci.getPoleHracov().get(hracNaTahu-1).getPeniaze() <= 0.0){
            System.out.println(this.hraci.getPoleHracov().get(hracNaTahu-1).getName()+" nemá dostatok financií a vypadáva z hry.");
            this.hraci.getPoleHracov().remove(this.hraci.getPoleHracov().get(hracNaTahu-1));
        }
        else{
            System.out.println(this.hraci.getPoleHracov().get(hracNaTahu-1).getName()+" zaplatil daň 2000.0");
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
