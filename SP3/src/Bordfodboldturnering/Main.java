package Bordfodboldturnering;

import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        KnockOutTurnering turnering = new KnockOutTurnering();
        turnering.læsHoldData("SP3/resources/hold_data.txt");
        turnering.kampCyklus();
        System.out.println(turnering.holdListe.size());
    }

}
