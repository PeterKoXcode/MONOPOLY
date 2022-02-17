package sk.stuba.fei.uim.oop.policko;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.jadro.BalicekKariet;
import sk.stuba.fei.uim.oop.jadro.Hraci;
import sk.stuba.fei.uim.oop.jadro.HraciePole;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class PolickoNehnutelnost extends Policko{

    private boolean naPredaj = true;
    private final double cenaKupi = 3000.0;
    private final double cenaStojneho = 1500.0;
    private final double cenaOdkupi = 3500.0;
    private Hrac owner;
    private int hracNaTahu;
    private Hraci hraci;
    private HraciePole hraciePole;



    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu, HraciePole hraciePole) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        this.hraciePole = hraciePole;
        printNehnutelnost();
    }

    public  PolickoNehnutelnost(){

    }

    private void printNehnutelnost(){
        Hrac currectPlayer = this.hraci.getPoleHracov().get(this.hracNaTahu-1);
        if(!this.naPredaj && this.owner != currectPlayer){                                                              // ak hrac ktory stupil na nehnutelnost nie je majitel a nehnutelnost nie je na predaj , tak..
            currectPlayer.setPeniaze(currectPlayer.getPeniaze()-this.cenaStojneho);                                     // hrac ktory stupil na nehnutelnost zaplati stojne
            stojneAleboVypadni(currectPlayer);
        }
        else if(getOwner() == currectPlayer){
            System.out.println(currectPlayer.getName()+" zastal na svojej nehnuteľnosti.");
        }
        else{
            kupNehnutelnost(currectPlayer);
        }
    }

    private void stojneAleboVypadni(Hrac currectPlayer){
        if(currectPlayer.getPeniaze() <= 0.0){
            System.out.println(currectPlayer.getName()+" nemá dostatok financií a vypadáva z hry");
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
                        if(polickoNehnutelnost.owner == currectPlayer){
                            polickoNehnutelnost.owner = null;
                            polickoNehnutelnost.naPredaj = true;
                        }
                        break;
                }
            }

            this.hraci.getPoleHracov().remove(currectPlayer);
        }
        else{
            System.out.println(currectPlayer.getName()+" zaplatil stojné v hodnote "+this.cenaStojneho);
            odkupNehnutelnost(currectPlayer);
        }
    }

    private char kupNekupNehnutelnost(){
        char kupNekup = KeyboardInput.readChar("Zadaj do klávesnice 'y' pokiaľ chceš pozemok kúpiť , alebo 'n' pokiaľ nechceš");
        if(kupNekup == 'y' || kupNekup == 'n'){
            return kupNekup;
        }
        else{
            System.out.println("Zadali ste neplatný znak. Zopakujte pokus a zadaj do klávesnice 'y' alebo 'n'.");
            kupNekupNehnutelnost();
        }
        return kupNekup;
    }

    private void odkupNehnutelnost(Hrac currectPlayer){
        if(currectPlayer.getPeniaze() > this.cenaOdkupi){
            char kupNekup = kupNekupNehnutelnost();
            odkupCiNe(kupNekup,currectPlayer);
        }
        else{
            System.out.println(currectPlayer.getName()+" nemá dostatok financií na kúpu tejto nehnuteľnosti.");
        }
    }

    private void odkupCiNe(char kupNekup,Hrac currectPlayer){
        if(kupNekup == 'y'){
            this.owner.setPeniaze(this.owner.getPeniaze()+this.cenaOdkupi);
            currectPlayer.setPeniaze(currectPlayer.getPeniaze()-this.cenaOdkupi);
            System.out.println(currectPlayer.getName()+" odkúpil nehnuteľnosť od "+this.owner.getName()+" za cenu "+this.cenaOdkupi);
            this.owner = currectPlayer;
        }
    }

    private void kupNehnutelnost(Hrac currectPlayer){
        if(currectPlayer.getPeniaze() > this.cenaKupi){
            char kupNekup = kupNekupNehnutelnost();
            kupCiNe(kupNekup,currectPlayer);
        }
        else{
            System.out.println(currectPlayer.getName()+" nemá dostatok financií na kúpu tejto nehnuteľnosti.");
        }
    }

    private void kupCiNe(char kupNekup,Hrac currectPlayer){
        if(kupNekup == 'y'){
            this.naPredaj = false;
            currectPlayer.setPeniaze(currectPlayer.getPeniaze()-this.cenaKupi);
            this.owner = currectPlayer;
            System.out.println(this.owner.getName()+" kúpil nehnuteľnosť za cenu "+this.cenaKupi);
        }
    }



    public Hrac getOwner() {
        return owner;
    }

    public void setOwner(Hrac owner) {
        this.owner = owner;
    }

    public boolean isNaPredaj() {
        return naPredaj;
    }

    public void setNaPredaj(boolean naPredaj) {
        this.naPredaj = naPredaj;
    }

    public double getCenaKupi() {
        return cenaKupi;
    }

    public double getCenaStojneho() {
        return cenaStojneho;
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
