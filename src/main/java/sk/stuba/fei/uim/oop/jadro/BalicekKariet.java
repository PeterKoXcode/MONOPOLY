package sk.stuba.fei.uim.oop.jadro;

import sk.stuba.fei.uim.oop.sance.*;

import java.util.concurrent.ArrayBlockingQueue;

public class BalicekKariet{

    private ArrayBlockingQueue<Sanca> balicekKariet = new ArrayBlockingQueue<Sanca>(15);

    public BalicekKariet() {
        for(int i = 0; i < 15; i++){
            switch (i){
                case 1:
                case 6:
                case 11:
                    this.balicekKariet.add(new SancaDostatPeniaze());
                    break;
                case 2:
                case 9:
                case 12:
                    this.balicekKariet.add(new SancaIstDoVazenia());
                    break;
                case 3:
                case 8:
                case 14:
                    this.balicekKariet.add(new SancaPresunNaStart());
                    break;
                case 0:
                case 5:
                case 10:
                    this.balicekKariet.add(new SancaPosunVPred());
                    break;
                case 4:
                case 7:
                case 13:
                    this.balicekKariet.add(new SancaZaplatitDane());
                    break;
            }
        }


    }
}
