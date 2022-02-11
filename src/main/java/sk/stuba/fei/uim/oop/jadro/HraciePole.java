package sk.stuba.fei.uim.oop.jadro;

import sk.stuba.fei.uim.oop.policko.*;

import java.util.ArrayList;

public class HraciePole {
    //{"1","2","2","3","2","2","1","2","2","3","2","2","1","2","2","3","2","2","1","2","2","3","2","2"}
    private final ArrayList<Policko> hraciePole;

    public HraciePole() {
        this.hraciePole = new ArrayList<>();
        for(int i = 0; i < 24 ; i++){
            switch (i){
                case 0:
                    this.hraciePole.add(new PolickoStart());
                    break;
                case 6:
                    this.hraciePole.add(new PolickoVazanie());
                    break;
                case 12:
                    this.hraciePole.add(new PolickoPolicia());
                    break;
                case 18:
                    this.hraciePole.add(new PolickoDane());
                    break;
                case 3:
                case 9:
                case 15:
                case 21:
                    this.hraciePole.add(new PolickoSanca());
                    break;
                default:
                    this.hraciePole.add(new PolickoNehnutelnost());
            }
        }
    }
}
