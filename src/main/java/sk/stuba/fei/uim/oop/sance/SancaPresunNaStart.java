package sk.stuba.fei.uim.oop.sance;

import sk.stuba.fei.uim.oop.hrac.Hrac;
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
        Hrac currentPlayer = this.hraci.getPoleHracov().get(this.hracNaTahu-1);
        System.out.println(currentPlayer.getName()+" si vytiahol šancu rýchly presun na štart.");
        currentPlayer.setPozicia(0);
        currentPlayer.setPeniaze(currentPlayer.getPeniaze()+this.startMoney);
        System.out.println(currentPlayer.getName()+" prešiel štartom a získal peniaze v hodnote "+this.startMoney);
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
