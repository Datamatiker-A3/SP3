package Bordfodboldturnering;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class KnockOutTurnering extends Turnering {
    FilLæser filLæser = new FilLæser();
    Random random = new Random();
    Random random2 = new Random();
    int nuværendeKamp = 1;
    int cyklus = 4;
    ArrayList<Kamp> kampOpsættelse = new ArrayList<>();
    ArrayList<Hold> holdListe = new ArrayList<>();

    public void kampCyklus(){

        fjernOverskud();
        for (int i = 0; i < cyklus; i++){
            opsætKamp(30);
            retunerHold();
        }
    }

    public void fjernOverskud(){
        if(holdListe.size() > 16){
            while(holdListe.size() != 16){
                holdListe.remove(holdListe.size()-1);
            }
        }
    }
    public void opsætKamp(int i){
        boolean erÆndret = false;
        while(holdListe.size() != 0) {
            int hold1 = random.nextInt(0, holdListe.size() - 1);
            int hold2 = random2.nextInt(0, holdListe.size() - 1);
            if (hold1 == hold2 && hold2 != holdListe.size() - 1) {
                hold2++;
                erÆndret = true;
            } else if (hold1 == hold2 && hold2 != 0) {
                hold2--;
                erÆndret = true;
            }
            Kamp kamp = new Kamp(holdListe.get(hold1), holdListe.get(hold2), i, nuværendeKamp);
            if(holdListe.size() >2) {
                if(hold1 > hold2) {
                    holdListe.remove(hold1);
                    if(erÆndret == true && hold2 != 0){
                        holdListe.remove(hold2);
                    }
                    else if(erÆndret == true && hold2 != holdListe.size()-1){
                        holdListe.remove(hold2);
                    }
                    else {
                        holdListe.remove(hold2);
                    }
                }
                else if(hold2>hold1){
                    if(erÆndret == true && hold2 != 0){
                        holdListe.remove(hold2);
                    }
                    else if(erÆndret == true && hold2 != holdListe.size()-1){
                        holdListe.remove(hold2);
                    }
                    else {
                        holdListe.remove(hold2);
                    }
                    holdListe.remove(hold1);
                }
            }
            else{holdListe.clear();}
            kampOpsættelse.add(kamp);
            System.out.println(kamp.hold1 + " spiller imod " + kamp.hold2);
            nuværendeKamp++;
        }
    }
    public void retunerHold(){
        for (Kamp kamp : kampOpsættelse){
            holdListe.add((kamp.findVinder()));
        }
        kampOpsættelse.clear();
    }
}
