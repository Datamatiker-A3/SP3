package Bordfodboldturnering;

import java.util.ArrayList;

public class Hold {
    private int Points = 0;

    private int målscore = 0;
    private String holdNavn;
    private int antalSpillere;
    private int holdID;
    private ArrayList<Kamp>kampHistorik=new ArrayList<>();

    public Hold(int holdID,String holdNavn, int antalSpillere) {
        this.holdID=holdID;
        this.holdNavn = holdNavn;
        this.antalSpillere = antalSpillere;

    }
    public int getMålscore() {
        return målscore;
    }

    public void setMålscore(int målscore) {
        this.målscore = målscore;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    public String getHoldNavn() {
        return holdNavn;
    }

    @Override
    public String toString(){
        return holdNavn;
    }

}
