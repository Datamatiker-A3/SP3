package Bordfodboldturnering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PointTurnering extends Turnering {
    int nuværeneKamp;
    public void læsHoldData(String data) throws FileNotFoundException {
        File file = new File(data);
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] lineArray = line.split(";");
            int holdIDtmp = Integer.parseInt(lineArray[0]);
            int antalSpilleretmp = Integer.parseInt(lineArray[2]);
            Hold hold = new Hold(holdIDtmp,lineArray[1],antalSpilleretmp);
            System.out.println(hold);
        }
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
