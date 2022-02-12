package sk.stuba.fei.uim.oop.sance;

import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class SancaPosunVPred extends Sanca{

    private int hracNaTahu;
    private Hraci hraci;
    private HraciePole hraciePole;
    private BalicekKariet balicekKariet;

    @Override
    public void typSance(Hraci hraci, int hracNaTahu, HraciePole hraciePole, BalicekKariet balicekKariet) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        this.hraciePole = hraciePole;
        this.balicekKariet = balicekKariet;
        printPosunVPred();
    }

    private void printPosunVPred(){
        System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" si vytiahol šancu posun vpred.");
        int randNum = posun();
        System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu - 1).getName()+" sa pohne o " + randNum + " dopredu.");
        this.hraci.getPoleHracov().get(this.hracNaTahu-1).setPozicia(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPozicia()+randNum);
        this.hraciePole.getHraciePole().get(this.hraci.getPoleHracov().get(this.hracNaTahu - 1).getPozicia()).funkciaPolicka(this.hraci,this.hracNaTahu,this.balicekKariet,this.hraciePole);

    }
    private int posun(){
        return (int) (Math.random() * 5 + 1);
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
