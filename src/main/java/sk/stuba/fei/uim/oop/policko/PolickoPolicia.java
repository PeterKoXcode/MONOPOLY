package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class PolickoPolicia extends Policko{
    private int hracNaTahu;
    private Hraci hraci;

    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu, HraciePole hraciePole) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        printPolice();
    }

    public PolickoPolicia(){}

    private void printPolice(){
        Hrac currentPlayer = this.hraci.getPoleHracov().get(this.hracNaTahu-1);
        currentPlayer.setUvazneny(true);
        currentPlayer.setPocetKolVoVazbe(2);
        System.out.println(currentPlayer.getName() + " bol uväznený na 2 kolá");
        currentPlayer.setPozicia(6);
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
