package Bordfodboldturnering;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    int input;
    boolean quit = false;
    boolean isFilLæser = false;
    boolean isDataBase = false;
    ArrayList<Hold> hold = new ArrayList<>();
    FilLæser filLæser = new FilLæser();
    DBConnector dbConnector = new DBConnector();
    KnockOutTurnering turnering = new KnockOutTurnering();

    public void menu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tast 1 for at læse holddata fra tekstfilen");
        System.out.println("Tast 2 for at læse holddata fra databasen");
            switch(sc.nextInt()){

                case 1:
                    hold = filLæser.læsHoldData("SP3/resources/hold_data.txt");
                    System.out.println("Holddata er nu indlæst fra tekstfilen");
                    isFilLæser = true;
                    break;
                case 2:
                    hold = dbConnector.readFieldData();
                    System.out.println("Holddata er nu indlæst fra databasen");
                    isDataBase = true;
                    break;
        }
        System.out.println("Tast 1 for at se holdnavnene");
        System.out.println("Tast 2 for at oprette en knock-out turnering");
        System.out.println("Tast 3 for at oprette en point turnering ");
        System.out.println("Tast 4 for at lukke programmet");
        do{
        input = sc.nextInt();
        switch(input) {
            case 1:
                if(isFilLæser == true) {
                    for (Hold hold : filLæser.holdListe) {
                        System.out.println(hold.getHoldNavn());
                    }
                }
                if(isDataBase == true){
                    for(Hold hold : dbConnector.holdListeDatabase){
                        System.out.println(hold.getHoldNavn());
                    }
                }
                break;
            case 2:
                    turnering.holdListe = hold;
                    turnering.kampCyklus();
                break;
            case 3:
                System.out.println("Der kan ikke oprettes en point turnering på nuværende tidspunkt");
                break;
            case 4:
                quit = true;
                break;

        }

        } while(!quit);
    }
}
