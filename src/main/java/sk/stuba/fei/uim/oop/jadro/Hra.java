package sk.stuba.fei.uim.oop.jadro;

import sk.stuba.fei.uim.oop.policko.*;

public class Hra {

    Hraci hraci;
    HraciePole hraciePole;
    BalicekKariet balicekKariet;

    public Hra(Hraci hraci, HraciePole hraciePole, BalicekKariet balicekKariet) {
        this.hraci = hraci;
        this.hraciePole = hraciePole;
        this.balicekKariet = balicekKariet;
        priebehHry();
    }

    private void priebehHry(){
        int hracNaTahu = 1;
        System.out.println("-----------------------------");
        while(hraci.poleHracov.size() != 1){
            if(hracNaTahu == hraci.poleHracov.size()+1){                                                                // podla poctu hracov nastavuje pocet kol kym sa vsetci vystriedaju a zacne odznova
                hracNaTahu = 1;
            }

            if(!hraci.poleHracov.get(hracNaTahu - 1).uvazneny) {                                                        // osetrenie ze hrac moze normalne hadzat kockou (neni vo vazeni)
                System.out.println("Na rade je " + hraci.poleHracov.get(hracNaTahu - 1).name);
                int hodnotaHodu = hraci.poleHracov.get(hracNaTahu - 1).padlo();                                         // hod kockou
                hraci.poleHracov.get(hracNaTahu - 1).pozicia += hodnotaHodu;                                            // posun o tolko policok kolko padlo na kocke
                System.out.println(hraci.poleHracov.get(hracNaTahu - 1).name + " hodil na kocke " + hodnotaHodu);
                if (hraci.poleHracov.get(hracNaTahu - 1).pozicia > 23) {                                                // osetrenie ze policko po poslednom policku bude znova start a takto dokola
                    int rozdiel = hraci.poleHracov.get(hracNaTahu - 1).pozicia - 23;
                    hraci.poleHracov.get(hracNaTahu - 1).pozicia = rozdiel - 1;

                    hraci.poleHracov.get(hracNaTahu-1).peniaze +=3000.0;                                                // ak presiel startom, dostane odmenu
                }
                System.out.println(hraci.poleHracov.get(hracNaTahu - 1).name + " stoji na policku cislo " + hraci.poleHracov.get(hracNaTahu - 1).pozicia);

                navstivenePolicko(hracNaTahu);                                                                          // skumame na akom policku som zastal

            }
            else{
                System.out.println(hraci.poleHracov.get(hracNaTahu - 1).name+" nehrá ešte "+(hraci.poleHracov.get(hracNaTahu-1).pocetKolVoVazbe-1)+". kolo");
                hraci.poleHracov.get(hracNaTahu-1).pocetKolVoVazbe--;                                                   // counter kolko kolbude hrac este vo vazbe
                if(hraci.poleHracov.get(hracNaTahu-1).pocetKolVoVazbe == 0){
                    hraci.poleHracov.get(hracNaTahu - 1).uvazneny = false;                                              // pokial je pocet kol nula , tak nastavime ze hrac nie je vazneny
                }
            }
//            if(hracNaTahu == 2 && startHry.poleHracov.get(hracNaTahu-1).name.equals("Jakub")) {
//                startHry.poleHracov.remove(hracNaTahu - 1);
//                hracNaTahu--;
//            }


            hracNaTahu++;
        }
    }
    private void navstivenePolicko(int hracNaTahu){
        switch (hraci.poleHracov.get(hracNaTahu - 1).pozicia){
            case 0:
                System.out.println("Políčko štart");
                break;
            case 6:
                System.out.println(hraci.poleHracov.get(hracNaTahu - 1).name+" navštívil väzenie.");
                break;
            case 12:
                //policia
                hraci.poleHracov.get(hracNaTahu-1).uvazneny=true;
                hraci.poleHracov.get(hracNaTahu-1).pocetKolVoVazbe = 2;
                System.out.println(hraci.poleHracov.get(hracNaTahu-1).name + " bol uväznený na 2 kolá");
                break;
            case 18:
                System.out.println("dane");
                break;
            case 3:
            case 9:
            case 15:
            case 21:
                System.out.println("sanca");
                break;
            default:
                System.out.println("nehnutelnost");
        }
    }
}
