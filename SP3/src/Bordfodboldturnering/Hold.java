package Bordfodboldturnering;

import java.util.ArrayList;

public class Hold {
    private String holdNavn;
    private int antalSpillere;
    private int point;
    private int målScore;
    private ArrayList<Kamp>kampHistorik=new ArrayList<>();

    public Hold(String holdNavn, int antalSpillere) {
        this.holdNavn = holdNavn;
        this.antalSpillere = antalSpillere;

    }
    public int beregnMålscore(){

        return målScore;
    }
}
