package Bordfodboldturnering;

import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        KnockOutTurnering turnering = new KnockOutTurnering();
        turnering.LæsFilData("SP3/resources/hold_data.txt");
        UI ui = new UI();
        ui.menu();
        //turnering.kampCyklus();

    }

}
