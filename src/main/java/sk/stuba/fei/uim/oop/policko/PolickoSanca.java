package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;
import sk.stuba.fei.uim.oop.sance.Sanca;

public class PolickoSanca extends Policko{

    private Hraci hraci;
    private int hracNaTahu;
    private final BalicekKariet balicekKariet;
    private HraciePole hraciePole;

    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu, HraciePole hraciePole) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        this.hraciePole = hraciePole;
        printSanca();
    }

    public PolickoSanca(BalicekKariet balicekKariet) {
        this.balicekKariet = balicekKariet;
    }

    private void printSanca(){
        System.out.println("Políčko šance:");
        Sanca vrchnakarta = this.balicekKariet.getBalicekKariet().get(0);


        vrchnakarta.typSance(this.hraci,this.hracNaTahu,this.hraciePole,this.balicekKariet);


        this.balicekKariet.getBalicekKariet().add(vrchnakarta);
        this.balicekKariet.getBalicekKariet().remove(0);












    }
}
