package Bordfodboldturnering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        KnockOutTurnering turnering = new KnockOutTurnering();
        turnering.læsHoldData("SP3/resources/hold_data.txt");
        turnering.circle();
        System.out.println(turnering.holdListe.size());
    }

}
