package sk.stuba.fei.uim.oop.jadro;

// Private field 'hraciePole' is assigned but never accessed

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.policko.*;

public class Hra {

    private final double startMoney = 3000.0;
    private final Hraci hraci;
    private final HraciePole hraciePole;

    public Hra(Hraci hraci, HraciePole hraciePole) {
        this.hraci = hraci;
        this.hraciePole = hraciePole;
        priebehHry();
    }

    private void priebehHry(){
        int hracNaTahu = 1;
        System.out.println("-----------------------------");

        while(this.hraci.getPoleHracov().size() != 1){
            if(hracNaTahu == this.hraci.getPoleHracov().size()+1){                                                                // podla poctu hracov nastavuje pocet kol kym sa vsetci vystriedaju a zacne odznova
                hracNaTahu = 1;
            }
            Hrac currentPlayer = this.hraci.getPoleHracov().get(hracNaTahu - 1);
            int pocetHracov = this.hraci.getPoleHracov().size(); //osetrenie Index Out Of Bounds Exception
            if(!currentPlayer.isUvazneny()) {                                                                              // osetrenie ze hrac moze normalne hadzat kockou (neni vo vazeni)
                System.out.println("Na rade je " + currentPlayer.getName());
                int hodnotaHodu = currentPlayer.padlo();                                                                  // hod kockou
                currentPlayer.setPozicia(currentPlayer.getPozicia()+hodnotaHodu);                                        // posun o tolko policok kolko padlo na kocke
                System.out.println(currentPlayer.getName() + " hodil na kocke " + hodnotaHodu);
                mimoScope(currentPlayer);
                System.out.println(currentPlayer.getName() + " stoji na policku cislo " + currentPlayer.getPozicia());
                System.out.println(currentPlayer.getPeniaze());

                this.hraciePole.getHraciePole().get(currentPlayer.getPozicia()).funkciaPolicka(this.hraci,hracNaTahu,this.hraciePole);// skumame na akom policku som zastal
            }
            else{
                System.out.println(currentPlayer.getName()+" nehrá ešte "+(currentPlayer.getPocetKolVoVazbe()-1)+". kolo");
                currentPlayer.setPocetKolVoVazbe(currentPlayer.getPocetKolVoVazbe()-1);                                        // counter kolko kolbude hrac este vo vazbe
                if(currentPlayer.getPocetKolVoVazbe() == 0){
                    currentPlayer.setUvazneny(false);                                                                       // pokial je pocet kol nula , tak nastavime ze hrac nie je vazneny
                }
            }

            if(pocetHracov == this.hraci.getPoleHracov().size()){                                                            // pokial za toto kolo nevypadol ziaden hrac tak bude dalsi na rade
                hracNaTahu++;                                                                                           // pokial vsak vypadol tak jeho miesto nahradi dalsi hrac a tym padom sa nemusi navysovat
            }
            int i = 0;
            for(Policko policko : this.hraciePole.getHraciePole()){
                if(policko instanceof PolickoNehnutelnost){
                    PolickoNehnutelnost polickoNehnutelnost = (PolickoNehnutelnost) policko;
                    System.out.println(i+" "+((polickoNehnutelnost.getOwner() == null)? "null": polickoNehnutelnost.getOwner().getName()));
                    i++;
                }
            }
        }
        System.out.println("WINNER IS "+ this.hraci.getPoleHracov().get(0).getName());
    }

    private void mimoScope(Hrac currentPlayer){
        if (currentPlayer.getPozicia() > 23) {                                                                             // osetrenie ze policko po poslednom policku bude znova start a takto dokola
            int rozdiel = currentPlayer.getPozicia() - 23;
            currentPlayer.setPozicia(rozdiel-1);

            currentPlayer.setPeniaze(currentPlayer.getPeniaze()+this.startMoney);                                           // ak presiel startom, dostane odmenu
            System.out.println(currentPlayer.getName()+" prešiel štartom a získal peniaze v hodnote "+this.startMoney);
        }
    }

}
