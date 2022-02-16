package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class PolickoVazanie extends Policko{

    private int hracNaTahu;
    private Hraci hraci;

    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu, HraciePole hraciePole) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        printJail();
    }

    public PolickoVazanie(){}

    private void printJail(){
        System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu - 1).getName()+" navštívil väzenie.");
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
