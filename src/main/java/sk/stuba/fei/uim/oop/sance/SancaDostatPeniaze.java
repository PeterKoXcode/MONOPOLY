package sk.stuba.fei.uim.oop.sance;

import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class SancaDostatPeniaze extends Sanca{

    private final double vyhra = 3000.0;
    private int hracNaTahu;
    private Hraci hraci;

    @Override
    public void typSance(Hraci hraci, int hracNaTahu, HraciePole hraciePole, BalicekKariet balicekKariet) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        printMoney();
    }

    private void printMoney(){
        System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" si vytiahol šancu získať peniaze.");
        this.hraci.getPoleHracov().get(this.hracNaTahu-1).setPeniaze(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze()+this.vyhra);
        System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" získal peniaze v hodnote "+ this.vyhra);
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
