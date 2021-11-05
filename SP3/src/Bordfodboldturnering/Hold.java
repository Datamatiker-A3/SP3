package Bordfodboldturnering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hold {
    private String holdNavn;
    private int antalSpillere;
    private int holdID;
    private ArrayList<Kamp>kampHistorik=new ArrayList<>();

    public Hold(int holdID,String holdNavn, int antalSpillere) {
        this.holdID=holdID;
        this.holdNavn = holdNavn;
        this.antalSpillere = antalSpillere;

    }

  /*  public void læsHoldData(String data) throws FileNotFoundException {
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
    }*/

    @Override
    public String toString(){
        return holdNavn + " " + antalSpillere;
    }

}
