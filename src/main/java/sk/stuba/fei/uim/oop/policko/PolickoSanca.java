package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;
import sk.stuba.fei.uim.oop.sance.Sanca;

public class PolickoSanca extends Policko{

    private Hraci hraci;
    private int hracNaTahu;
    private BalicekKariet balicekKariet;
    private HraciePole hraciePole;

    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu, BalicekKariet balicekKariet, HraciePole hraciePole) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        this.balicekKariet = balicekKariet;
        this.hraciePole = hraciePole;
        printSanca();
    }

    public PolickoSanca() {
    }

    private void printSanca(){
        System.out.println("Políčko šance:");
        Sanca vrchnakarta = balicekKariet.getBalicekKariet().get(0);


        vrchnakarta.typSance(hraci,hracNaTahu,hraciePole,balicekKariet);


        balicekKariet.getBalicekKariet().add(vrchnakarta);
        balicekKariet.getBalicekKariet().remove(0);












    }
}
