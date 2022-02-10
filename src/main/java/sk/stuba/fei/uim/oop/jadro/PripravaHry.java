package sk.stuba.fei.uim.oop.jadro;

public class PripravaHry {

    public PripravaHry() {
        var Hraci = new Hraci();
        var hraciePole = new HraciePole();
        var balicekKariet = new BalicekKariet();
        new Hra(Hraci,hraciePole,balicekKariet);
    }
}
