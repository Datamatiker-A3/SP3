package Bordfodboldturnering;

import java.util.ArrayList;

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

    @Override
    public String toString(){
        return holdNavn + " " + antalSpillere;
    }

}
