package sk.stuba.fei.uim.oop.jadro;

import sk.stuba.fei.uim.oop.policko.*;

import java.util.ArrayList;

public class HraciePole {
    //{"1","2","2","3","2","2","1","2","2","3","2","2","1","2","2","3","2","2","1","2","2","3","2","2"}
    public final ArrayList<Policko> hraciePole;

    public HraciePole() {
        hraciePole = new ArrayList<>();
        for(int i = 0; i < 24 ; i++){
            switch (i){
                case 0:
                    hraciePole.add(new PolickoStart(i));
                    break;
                case 6:
                    hraciePole.add(new PolickoVazanie(i));
                    break;
                case 12:
                    hraciePole.add(new PolickoPolicia(i));
                    break;
                case 18:
                    hraciePole.add(new PolickoDane(i));
                    break;
                case 3:
                case 9:
                case 15:
                case 21:
                    hraciePole.add(new PolickoSanca(i));
                    break;
                default:
                    hraciePole.add(new PolickoNehnutelnost(i));
            }
        }
    }
}
