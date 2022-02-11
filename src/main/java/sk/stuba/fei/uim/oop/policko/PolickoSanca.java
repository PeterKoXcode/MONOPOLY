package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.jadro.Hraci;

public class PolickoSanca extends Policko{

    private Hraci hraci;
    private int hracNaTahu;

    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;

    }
}
