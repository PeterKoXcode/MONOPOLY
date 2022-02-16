package sk.stuba.fei.uim.oop.sance;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;

public class SancaPosunVPred extends Sanca{

    private final double startMoney = 3000.0;
    private int hracNaTahu;
    private Hraci hraci;
    private HraciePole hraciePole;
    private BalicekKariet balicekKariet;

    @Override
    public void typSance(Hraci hraci, int hracNaTahu, HraciePole hraciePole, BalicekKariet balicekKariet) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        this.hraciePole = hraciePole;
        this.balicekKariet = balicekKariet;
        printPosunVPred();
    }

    private void printPosunVPred(){
        Hrac currentPlayer = this.hraci.getPoleHracov().get(this.hracNaTahu-1);
        System.out.println(currentPlayer.getName()+" si vytiahol šancu posun vpred.");
        int randNum = posun();
        System.out.println(currentPlayer.getName()+" sa pohne o " + randNum + " dopredu.");
        currentPlayer.setPozicia(currentPlayer.getPozicia()+randNum);
        mimoScope(currentPlayer);
        System.out.println(currentPlayer.getPeniaze());
        this.hraciePole.getHraciePole().get(currentPlayer.getPozicia()).funkciaPolicka(this.hraci,this.hracNaTahu,this.hraciePole);
        // hadze tu exception
    }

    private void mimoScope(Hrac currentPlayer){
        if (currentPlayer.getPozicia() > 23) {                                                                             // osetrenie ze policko po poslednom policku bude znova start a takto dokola
            int rozdiel = currentPlayer.getPozicia() - 23;
            currentPlayer.setPozicia(rozdiel-1);

            currentPlayer.setPeniaze(currentPlayer.getPeniaze()+this.startMoney);                                           // ak presiel startom, dostane odmenu
            System.out.println(currentPlayer.getName()+" prešiel štartom a získal peniaze v hodnote "+this.startMoney);
        }
    }

    private int posun(){
        return (int) (Math.random() * 5 + 1);
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
