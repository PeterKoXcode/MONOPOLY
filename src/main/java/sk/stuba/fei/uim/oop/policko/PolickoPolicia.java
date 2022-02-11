package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.jadro.Hraci;

public class PolickoPolicia extends Policko{
    private int hracNaTahu;
    private Hraci hraci;

    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        printPolice();
    }

    public PolickoPolicia(){}

    private void printPolice(){
        this.hraci.getPoleHracov().get(hracNaTahu-1).setUvazneny(true);
        this.hraci.getPoleHracov().get(hracNaTahu-1).setPocetKolVoVazbe(2);
        System.out.println(this.hraci.getPoleHracov().get(hracNaTahu-1).getName() + " bol uväznený na 2 kolá");
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
