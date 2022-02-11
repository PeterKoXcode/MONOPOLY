package sk.stuba.fei.uim.oop.jadro;

// Private field 'hraciePole' is assigned but never accessed

import sk.stuba.fei.uim.oop.policko.*;

public class Hra {

    private final Hraci hraci;
    private final HraciePole hraciePole;
    private final BalicekKariet balicekKariet;

    public Hra(Hraci hraci, HraciePole hraciePole, BalicekKariet balicekKariet) {
        this.hraci = hraci;
        this.hraciePole = hraciePole;
        this.balicekKariet = balicekKariet;
        priebehHry();
    }

    private void priebehHry(){
        int hracNaTahu = 1;
        System.out.println("-----------------------------");
//        Policko init = this.hraciePole.getHraciePole().get(this.hraci.getPoleHracov().get(hracNaTahu).getPozicia());
//        init.setOwner(hraci.getPoleHracov().get(hracNaTahu));
//        if(init.getOwner() == hraci.getPoleHracov().get(hracNaTahu)){
//            System.out.println("funguje to");
//        }
//        System.out.println("-----------------------------");
        while(this.hraci.getPoleHracov().size() != 1){
            if(hracNaTahu == this.hraci.getPoleHracov().size()+1){                                                                // podla poctu hracov nastavuje pocet kol kym sa vsetci vystriedaju a zacne odznova
                hracNaTahu = 1;
            }
            int pocetHracov = this.hraci.getPoleHracov().size(); //osetrenie Index Out Of Bounds Exception
            if(!this.hraci.getPoleHracov().get(hracNaTahu - 1).isUvazneny()) {                                                        // osetrenie ze hrac moze normalne hadzat kockou (neni vo vazeni)
                System.out.println("Na rade je " + this.hraci.getPoleHracov().get(hracNaTahu - 1).getName());
                int hodnotaHodu = this.hraci.getPoleHracov().get(hracNaTahu - 1).padlo();                                         // hod kockou
                this.hraci.getPoleHracov().get(hracNaTahu - 1).setPozicia(this.hraci.getPoleHracov().get(hracNaTahu-1).getPozicia()+hodnotaHodu);       // posun o tolko policok kolko padlo na kocke
                System.out.println(this.hraci.getPoleHracov().get(hracNaTahu - 1).getName() + " hodil na kocke " + hodnotaHodu);
                if (this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia() > 23) {                                                // osetrenie ze policko po poslednom policku bude znova start a takto dokola
                    int rozdiel = this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia() - 23;
                    this.hraci.getPoleHracov().get(hracNaTahu - 1).setPozicia(rozdiel-1);

                    //this.hraci.getPoleHracov().get(hracNaTahu-1).setPeniaze(this.hraci.getPoleHracov().get(hracNaTahu-1).getPeniaze()+3000.0);        // ak presiel startom, dostane odmenu
                }
                System.out.println(this.hraci.getPoleHracov().get(hracNaTahu - 1).getName() + " stoji na policku cislo " + this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia());
                System.out.println(this.hraci.getPoleHracov().get(hracNaTahu-1).getPeniaze());
                navstivenePolicko(hracNaTahu);                                                                          // skumame na akom policku som zastal

            }
            else{
                System.out.println(this.hraci.getPoleHracov().get(hracNaTahu - 1).getName()+" nehrá ešte "+(this.hraci.getPoleHracov().get(hracNaTahu-1).getPocetKolVoVazbe()-1)+". kolo");
                this.hraci.getPoleHracov().get(hracNaTahu-1).setPocetKolVoVazbe(this.hraci.getPoleHracov().get(hracNaTahu-1).getPocetKolVoVazbe()-1);         // counter kolko kolbude hrac este vo vazbe
                if(this.hraci.getPoleHracov().get(hracNaTahu-1).getPocetKolVoVazbe() == 0){
                    this.hraci.getPoleHracov().get(hracNaTahu - 1).setUvazneny(false);                                            // pokial je pocet kol nula , tak nastavime ze hrac nie je vazneny
                }
            }

            if(pocetHracov == this.hraci.getPoleHracov().size()){                                                            // pokial za toto kolo nevypadol ziaden hrac tak bude dalsi na rade
                hracNaTahu++;                                                                                           // pokial vsak vypadol tak jeho miesto nahradi dalsi hrac a tym padom sa nemusi navysovat
            }
            int i = 0;
            for(Policko policko : hraciePole.getHraciePole()){
                if(policko instanceof PolickoNehnutelnost){
                    PolickoNehnutelnost polickoNehnutelnost = (PolickoNehnutelnost) policko;
                    System.out.println(i+" "+((polickoNehnutelnost.getOwner() == null)? "null": polickoNehnutelnost.getOwner().getName()));
                    i++;
                }
            }
        }
        System.out.println("WINNER IS "+ this.hraci.getPoleHracov().get(0).getName());
    }
    private void navstivenePolicko(int hracNaTahu){
        switch (this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia()){
            case 0:
                hraciePole.getHraciePole().get(this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia()).funkciaPolicka(hraci,hracNaTahu); // vypise "Políčko štart"
                break;
            case 6:
                hraciePole.getHraciePole().get(this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia()).funkciaPolicka(hraci,hracNaTahu); // vypise "Navteva vazenia"
                break;
            case 12:
                hraciePole.getHraciePole().get(this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia()).funkciaPolicka(hraci,hracNaTahu); // na 2 kola zavrie hraca do vazby
                break;
            case 18:
                hraciePole.getHraciePole().get(this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia()).funkciaPolicka(hraci,hracNaTahu); // hrac zaplati dane v hodnote 2000.0
                break;
            case 3:
            case 9:
            case 15:
            case 21:
                hraciePole.getHraciePole().get(this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia()).funkciaPolicka(hraci,hracNaTahu);
                break;
            default:
                //System.out.println("nehnutelnost");
                hraciePole.getHraciePole().get(this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia()).funkciaPolicka(hraci,hracNaTahu);
                //new PolickoNehnutelnost(hracNaTahu,hraci,this.hraciePole.getHraciePole().get(this.hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia()));
        }
    }


}
