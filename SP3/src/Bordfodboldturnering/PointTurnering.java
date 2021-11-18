package Bordfodboldturnering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PointTurnering extends Turnering {
    FilLæser filLæser = new FilLæser();
    Random random = new Random();
    Random random2 = new Random();
    int nuværendeKamp = 1;
    int cyklus = 4;
    ArrayList<Hold> holdListe = new ArrayList<>();
    ArrayList<Kamp> kampOpsættelse = new ArrayList<>();
    Hold[] finalisterne = new Hold[4];
    public void læsFilData(String s) throws FileNotFoundException{
        holdListe = filLæser.læsHoldData(s);
    }
    public void kampCyklus(){
        fjernOverskud();
        for (int i = 0; i < cyklus; i++){
            opsætKamp(30);
            retunerHold();
        }
        findFinalister();
        sidsteKampe();
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
            kamp.findVinderPoints();
                holdListe.add(kamp.getHold1());
                holdListe.add(kamp.getHold2());

        }
        kampOpsættelse.clear();
    }
    public void findFinalister(){
        for (int i = 0; i <finalisterne.length; i++){
            finalisterne[i] = new Hold(0,"0",0);
        }
        for (int i = 0; i < holdListe.size(); i++) {
            for (int j = 0; j < finalisterne.length; j++) {
                if(holdListe.get(i).getPoints() > finalisterne[j].getPoints()){
                    finalisterne[j] = holdListe.get(i);
                    break;
                }
                else if(holdListe.get(i).getPoints() == finalisterne[j].getPoints() && holdListe.get(i).getMålscore() > finalisterne[j].getMålscore()){
                    finalisterne[j] = holdListe.get(i);
                    break;
                }
            }
        }
    }
    public void sidsteKampe(){
        for (int i = 0; i <finalisterne.length; i++){
            System.out.println(finalisterne[i] + " er en finalist med " + finalisterne[i].getPoints() + " point");
        }
        Kamp kamp = new Kamp(finalisterne[0],finalisterne[1],30,nuværendeKamp);
        Hold finalist1 = kamp.findVinder();
        Kamp kamp2 = new Kamp(finalisterne[2],finalisterne[3],30,nuværendeKamp);
        Hold finalist2 = kamp2.findVinder();
        Kamp kamp3 = new Kamp(finalist1,finalist2,30,nuværendeKamp);
        Hold vinder = kamp3.findVinder();
        System.out.println(vinder + " vandt tuneringen");

    }
}
