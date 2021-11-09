package Bordfodboldturnering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class KnockOutTurnering extends Turnering {
    Random random = new Random();
    Random random2 = new Random();
    int nuværendeKamp = 1;
    ArrayList<Kamp> kampOpsættelse = new ArrayList<>();
    ArrayList<Hold> holdListe = new ArrayList<>();
    public void læsHoldData(String data) throws FileNotFoundException {
        File file = new File(data);
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] lineArray = line.split(";");
            int holdIDtmp = Integer.parseInt(lineArray[0]);
            int antalSpilleretmp = Integer.parseInt(lineArray[2]);
            Hold hold = new Hold(holdIDtmp,lineArray[1],antalSpilleretmp);
            holdListe.add(hold);
        }
    }
    public void fjernOverskud(){
        if(holdListe.size() > 16){
            while(holdListe.size() != 16){
                System.out.println(holdListe.get(holdListe.size()-1));
                holdListe.remove(holdListe.size()-1);
            }
        }
    }
    public void opsætKamp(int i) throws IndexOutOfBoundsException{
        boolean isChanged = false;
        while(holdListe.size() != 0) {
            System.out.println(holdListe.size() + " holdliste size");
            int hold1 = random.nextInt(0, holdListe.size() - 1);
            System.out.println(hold1 + " Team 1");
            int hold2 = random2.nextInt(0, holdListe.size() - 1);
            System.out.println(hold2 + " Team 2 pre");
            if (hold1 == hold2 && hold2 != holdListe.size() - 1) {
                hold2++;
                isChanged = true;
            } else if (hold1 == hold2 && hold2 != 0) {
                hold2--;
                isChanged = true;
            }
            System.out.println(hold2 + " Team 2 post");
            Kamp kamp = new Kamp(holdListe.get(hold1), holdListe.get(hold2), i, nuværendeKamp);
            System.out.println("Speedbumb 1");
            if(holdListe.size() >2) {
                holdListe.remove(hold1);
                if(isChanged == true && hold2 != 0){
                    holdListe.remove(hold2-1);
                }
                else if(isChanged == true && hold2 != holdListe.size()-1){
                    holdListe.remove(hold2+1);
                }
                else {
                    holdListe.remove(hold2);
                }
            }
            else{holdListe.clear();}
            kampOpsættelse.add(kamp);
            System.out.println(kamp.hold1 + " spiller imod " + kamp.hold2);
            nuværendeKamp++;
            System.out.println("Speedbumb 2");
        }
    }
}
