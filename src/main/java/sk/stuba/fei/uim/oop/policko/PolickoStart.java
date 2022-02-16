package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class PolickoStart extends Policko{


    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu, HraciePole hraciePole) {
        printStart();
    }

    private void printStart(){
        System.out.println("Políčko štart");
    }



}
