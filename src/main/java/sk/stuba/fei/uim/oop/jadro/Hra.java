package sk.stuba.fei.uim.oop.jadro;

// Private field 'hraciePole' is assigned but never accessed

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
        while(hraci.getPoleHracov().size() != 1){
            if(hracNaTahu == hraci.getPoleHracov().size()+1){                                                                // podla poctu hracov nastavuje pocet kol kym sa vsetci vystriedaju a zacne odznova
                hracNaTahu = 1;
            }

            if(!hraci.getPoleHracov().get(hracNaTahu - 1).isUvazneny()) {                                                        // osetrenie ze hrac moze normalne hadzat kockou (neni vo vazeni)
                System.out.println("Na rade je " + hraci.getPoleHracov().get(hracNaTahu - 1).getName());
                int hodnotaHodu = hraci.getPoleHracov().get(hracNaTahu - 1).padlo();                                         // hod kockou
                hraci.getPoleHracov().get(hracNaTahu - 1).setPozicia(hraci.getPoleHracov().get(hracNaTahu-1).getPozicia()+hodnotaHodu);       // posun o tolko policok kolko padlo na kocke
                System.out.println(hraci.getPoleHracov().get(hracNaTahu - 1).getName() + " hodil na kocke " + hodnotaHodu);
                if (hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia() > 23) {                                                // osetrenie ze policko po poslednom policku bude znova start a takto dokola
                    int rozdiel = hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia() - 23;
                    hraci.getPoleHracov().get(hracNaTahu - 1).setPozicia(rozdiel-1);

                    //hraci.poleHracov.get(hracNaTahu-1).setPeniaze(hraci.poleHracov.get(hracNaTahu-1).getPeniaze()+3000.0);        // ak presiel startom, dostane odmenu
                }
                System.out.println(hraci.getPoleHracov().get(hracNaTahu - 1).getName() + " stoji na policku cislo " + hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia());
                System.out.println(hraci.getPoleHracov().get(hracNaTahu-1).getPeniaze());
                navstivenePolicko(hracNaTahu);                                                                          // skumame na akom policku som zastal
//                if(hraci.poleHracov.size() == 1) {
//                    break;
//                }
            }
            else{
                System.out.println(hraci.getPoleHracov().get(hracNaTahu - 1).getName()+" nehrá ešte "+(hraci.getPoleHracov().get(hracNaTahu-1).getPocetKolVoVazbe()-1)+". kolo");
                hraci.getPoleHracov().get(hracNaTahu-1).setPocetKolVoVazbe(hraci.getPoleHracov().get(hracNaTahu-1).getPocetKolVoVazbe()-1);         // counter kolko kolbude hrac este vo vazbe
                if(hraci.getPoleHracov().get(hracNaTahu-1).getPocetKolVoVazbe() == 0){
                    hraci.getPoleHracov().get(hracNaTahu - 1).setUvazneny(false);                                            // pokial je pocet kol nula , tak nastavime ze hrac nie je vazneny
                }
            }
//            if(hracNaTahu == 2 && startHry.poleHracov.get(hracNaTahu-1).name.equals("Jakub")) {
//                startHry.poleHracov.remove(hracNaTahu - 1);
//                hracNaTahu--;
//            }


            hracNaTahu++;
        }
        System.out.println("WINNER IS "+ hraci.getPoleHracov().get(0).getName());
    }
    private void navstivenePolicko(int hracNaTahu){
        switch (hraci.getPoleHracov().get(hracNaTahu - 1).getPozicia()){
            case 0:
                System.out.println("Políčko štart");
                break;
            case 6:
                System.out.println(hraci.getPoleHracov().get(hracNaTahu - 1).getName()+" navštívil väzenie.");
                break;
            case 12:
                //policia
                hraci.getPoleHracov().get(hracNaTahu-1).setUvazneny(true);
                hraci.getPoleHracov().get(hracNaTahu-1).setPocetKolVoVazbe(2);
                System.out.println(hraci.getPoleHracov().get(hracNaTahu-1).getName() + " bol uväznený na 2 kolá");
                break;
            case 18:
                //dane
                hraci.getPoleHracov().get(hracNaTahu-1).setPeniaze(hraci.getPoleHracov().get(hracNaTahu-1).getPeniaze()-2000.0);
                if(hraci.getPoleHracov().get(hracNaTahu-1).getPeniaze() <= 0.0){
                    System.out.println(hraci.getPoleHracov().get(hracNaTahu-1).getName()+" nemá dostatok financií a vypadáva z hry.");
                    hraci.getPoleHracov().remove(hraci.getPoleHracov().get(hracNaTahu-1));
                }
                else{
                    System.out.println(hraci.getPoleHracov().get(hracNaTahu-1).getName()+" zaplatil daň 2000.0");
                }
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
