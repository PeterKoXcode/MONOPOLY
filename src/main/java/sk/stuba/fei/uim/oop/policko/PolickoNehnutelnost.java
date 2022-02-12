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


    @Override
    public void funkciaPolicka(Hraci hraci, int hracNaTahu, BalicekKariet balicekKariet, HraciePole hraciePole) {
        this.hraci = hraci;
        this.hracNaTahu = hracNaTahu;
        printNehnutelnost();
    }

    public  PolickoNehnutelnost(){

    }

    private void printNehnutelnost(){
        if(!this.naPredaj && this.owner != this.hraci.getPoleHracov().get(this.hracNaTahu-1)){ // ak hrac ktory stupil na nehnutelnost nie je majitel a nehnutelnost nie je na predaj , tak..
            this.hraci.getPoleHracov().get(this.hracNaTahu-1).setPeniaze(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze()-this.cenaStojneho);   // hrac ktory stupil na nehnutelnost zaplati stojne
            if(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze() <= 0.0){
                System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" nemá dostatok financií a vypadáva z hry");
                for(int i = 0; i < this.hraci.getPoleHracov().get(hracNaTahu-1).getVlastnictvo2().size();i++){
                    //this.hraci.getPoleHracov().get(hracNaTahu-1).getVlastnictvo().set(i,null);
                    this.hraci.getPoleHracov().get(hracNaTahu-1).setPozicia(this.hraci.getPoleHracov().get(hracNaTahu-1).getVlastnictvo2().get(i));


                    // scenar 1 - pri vytvarani ownera konkretneho policka , zapisovat niekam

                    // osetrit vymazanie majetku
                }
                this.hraci.getPoleHracov().remove(this.hraci.getPoleHracov().get(this.hracNaTahu-1));
                return;
            }
            else{
                System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" zaplatil stojné v hodnote "+this.cenaStojneho);
            }
            if(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze() > this.cenaOdkupi){
                char kupNekup = kupNekupNehnutelnost();
                if(kupNekup == 'y'){
                    this.owner.setPeniaze(this.owner.getPeniaze()+this.cenaOdkupi);
                    this.hraci.getPoleHracov().get(this.hracNaTahu-1).setPeniaze(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze()-this.cenaOdkupi);
                    System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" odkúpil nehnuteľnosť od "+this.owner.getName()+" za cenu "+this.cenaOdkupi);
                    this.owner = this.hraci.getPoleHracov().get(this.hracNaTahu-1);
                    this.hraci.getPoleHracov().get(hracNaTahu-1).getVlastnictvo2().add(this.hraci.getPoleHracov().get(hracNaTahu-1).getPozicia());
                }
            }
            else{
                System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" nemá dostatok financií na kúpu tejto nehnuteľnosti.");
            }
        }
        else if(getOwner() == this.hraci.getPoleHracov().get(this.hracNaTahu-1)){
            System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" zastal na svojej nehnuteľnosti.");
        }
        else{
            if(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze() > this.cenaKupi){
                char kupNekup = kupNekupNehnutelnost();
                if(kupNekup == 'y'){
                    this.naPredaj = false;
                    this.hraci.getPoleHracov().get(this.hracNaTahu-1).setPeniaze(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getPeniaze()-this.cenaKupi);
                    this.owner = this.hraci.getPoleHracov().get(this.hracNaTahu-1);
                    this.hraci.getPoleHracov().get(hracNaTahu-1).getVlastnictvo2().add(this.hraci.getPoleHracov().get(hracNaTahu-1).getPozicia());
                    System.out.println(this.owner.getName()+" kúpil nehnuteľnosť za cenu "+this.cenaKupi);
                }
            }
            else{
                System.out.println(this.hraci.getPoleHracov().get(this.hracNaTahu-1).getName()+" nemá dostatok financií na kúpu tejto nehnuteľnosti.");
            }
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
