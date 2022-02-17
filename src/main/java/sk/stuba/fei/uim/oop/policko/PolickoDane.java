package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class PolickoDane extends Policko{
    private final double cenaDane = 2000.0;
    private int hracNaTahu;
    private Hraci hraci;
    private HraciePole hraciePole;

    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu, HraciePole hraciePole) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        this.hraciePole = hraciePole;
        printDane();
    }


    public PolickoDane(){}

    private void printDane(){
        Hrac currentPlayer = this.hraci.getPoleHracov().get(this.hracNaTahu-1);
        currentPlayer.setPeniaze(currentPlayer.getPeniaze()-this.cenaDane);
        if(currentPlayer.getPeniaze() <= 0.0){
            System.out.println(currentPlayer.getName()+" nemá dostatok financií a vypadáva z hry.");

            // odstranenie majetku
            for(int i = 0; i < this.hraciePole.getHraciePole().size(); i++){
                switch (i){
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 11:
                    case 13:
                    case 14:
                    case 16:
                    case 17:
                    case 19:
                    case 20:
                    case 22:
                    case 23:
                        PolickoNehnutelnost polickoNehnutelnost = (PolickoNehnutelnost) this.hraciePole.getHraciePole().get(i);
                        if(polickoNehnutelnost.getOwner() == currentPlayer){
                            polickoNehnutelnost.setOwner(null);
                            polickoNehnutelnost.setNaPredaj(true);
                        }
                        break;
                }
            }


            this.hraci.getPoleHracov().remove(currentPlayer);

        }
        else{
            System.out.println(currentPlayer.getName()+" zaplatil daň 2000.0");
        }
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
