package Bordfodboldturnering;

import java.util.Random;

public class Kamp {
    int kamplængde;
    int kampID;
    Hold hold1;
    Hold hold2;
    Hold[] beggeHold = new Hold[2];

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
    public Hold[] findVinderPoints(){
        Random random = new Random();
        int vælgHold = random.nextInt(0,1);
        if (vælgHold == 0){
            System.out.println(hold1 + " vandt");
            hold1.setPoints(hold1.getPoints()+2);
           int vindertal = random.nextInt(1,10);
           int tabertal = random.nextInt(0,vindertal-1);
           hold1.setMålscore(hold1.getMålscore()+vindertal);
           hold2.setMålscore(hold2.getMålscore()+tabertal);

            return beggeHold;
        }
        else {
            System.out.println(hold2 + " vandt");
            int vindertal = random.nextInt(1,10);
            int tabertal = random.nextInt(0,vindertal-1);
            hold2.setMålscore(hold2.getMålscore()+vindertal);
            hold1.setMålscore(hold1.getMålscore()+tabertal);
            hold2.setPoints(hold2.getPoints()+2);
            return beggeHold;
        }
    }


}
