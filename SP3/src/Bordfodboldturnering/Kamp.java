package Bordfodboldturnering;

import java.util.Random;

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
    public Hold findVinder(){
        Random random = new Random();
        int vælgHold = random.nextInt(0,1);
        if (vælgHold == 0){
            System.out.println(hold1 + " vandt");
            return hold1;
        }
        else {
            System.out.println(hold2 + " vandt");
            return hold2;
        }
    }

}
