package sk.stuba.fei.uim.oop.sance;

import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class SancaPresunNaStart extends Sanca{

    private final double startMoney = 3000.0;
    private int hracNaTahu;
    private Hraci hraci;

    @Override
    public void typSance(Hraci hraci, int hracNaTahu, HraciePole hraciePole, BalicekKariet balicekKariet) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        printSancaStart();
    }

    private void printSancaStart(){
        System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" si vytiahol šancu rýchly presun na štart.");
        this.hraci.getPoleHracov().get(this.hracNaTahu-1).setPozicia(0);
        this.hraci.getPoleHracov().get(this.hracNaTahu-1).setPeniaze(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze()+this.startMoney);
        System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" prešiel štartom a získal peniaze v hodnote "+this.startMoney);
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
