package Bordfodboldturnering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PointTurnering extends Turnering {
    FilLæser filLæser = new FilLæser();
    int nuværeneKamp;
    ArrayList<Hold> holdListe = new ArrayList<>();
    public void LæsFilData(String s) throws FileNotFoundException{
        holdListe = filLæser.læsHoldData(s);
    }
    public void fjernOverskud(){
       /* if(holdListe.size() > 16){
            for(int i = 16; i < holdListe.size(); i++){
                holdListe.remove(i);
            }
        }
        System.out.println(holdListe);*/
    }
    public void opsætKamp(int i){
        /*
        int hold1 = random.nextInt(0, holdListe.size()-1);
        holdListe.remove(hold1);
        int hold2 = random.nextInt(0, holdListe.size()-1);
        holdListe.remove(hold2);
        Kamp kamp = new Kamp(holdListe.get(hold1),holdListe.get(hold2),i, nuværeneKamp);
        kampOpsættelse.add(kamp);
        nuværeneKamp++;
        System.out.println(holdListe);
        */
    }
}
