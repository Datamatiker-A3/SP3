package Bordfodboldturnering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class KnockOutTurnering extends Turnering {
    Random random = new Random();
    Random random2 = new Random();
    int nuværeneKamp = 1;
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
    public void opsætKamp(int i){
        int hold1 = random.nextInt(0, holdListe.size()-1);
        System.out.println(hold1);
        int hold2 = random2.nextInt(0, holdListe.size()-1);
        System.out.println(hold2);
        if(hold1 == hold2 && hold2 !=holdListe.size()-1){
            hold2++;
        }
        else if (hold1 == hold2 && hold2 != 0){
            hold2--;
        }
        else {}
        Kamp kamp = new Kamp(holdListe.get(hold1),holdListe.get(hold2),i, nuværeneKamp);
        holdListe.remove(hold1);
        holdListe.remove(hold2);
        kampOpsættelse.add(kamp);
        System.out.println(kamp.hold1);
        System.out.println(kamp.hold2);
        nuværeneKamp++;
        System.out.println(holdListe.size());
    }
}
