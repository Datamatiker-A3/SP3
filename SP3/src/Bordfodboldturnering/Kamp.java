package Bordfodboldturnering;

public class Kamp {
    int kamplængde;
    int kampID;
    int [] resultat = new int[2];
    Hold hold1;
    Hold hold2;

    public Kamp(Hold hold1, Hold hold2, int kamplængde, int kampID) {
        this.kamplængde = kamplængde;
        this.kampID = kampID;
        this.hold1 = hold1;
        this.hold2 = hold2;
    }
    private void findVinder(){
       hold1.setPoints(hold1.getPoints()+2);
    }


}
