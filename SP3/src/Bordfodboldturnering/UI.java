package Bordfodboldturnering;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    FilLæser filLæser = new FilLæser();
    KnockOutTurnering turnering = new KnockOutTurnering();

    public void menu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tast 1 for at læse holddata fra tekstfilen");
        System.out.println("Tast 2 for at læse holddata fra databasen");
            switch(sc.nextInt()){

                case 1:
                    filLæser.læsHoldData("SP3/resources/hold_data.txt");
                    System.out.println("Holddata er nu indlæst fra tekstfilen");
                    break;
                case 2:

                    System.out.println("Holddata er nu indlæst fra databasen");
                    break;
        }
        System.out.println("Tast 1 for at se holdnavnene");
        System.out.println("Tast 2 for at oprette en knock-out turnering");
        System.out.println("Tast 3 for at oprette en point turnering ");
        switch(sc.nextInt()){
            case 1:
                for( Hold hold : filLæser.holdListe) {
                    System.out.println(hold.getHoldNavn());
                }
                break;
            case 2:
                turnering.kampOpsættelse

                turnering.kampCyklus();
                break;
            case 3:
                break;
        }
    }
}
