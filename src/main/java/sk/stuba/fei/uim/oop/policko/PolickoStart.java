package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.jadro.Hraci;

public class PolickoStart extends Policko{


    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu) {
        printStart();
    }

    private void printStart(){
        System.out.println("Políčko štart");
    }



}
