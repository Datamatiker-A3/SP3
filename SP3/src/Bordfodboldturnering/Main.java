package Bordfodboldturnering;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
       // UI ui = new UI();
     //   ui.menu();
       PointTurnering pointTurnering = new PointTurnering();
        pointTurnering.læsFilData("SP3/resources/hold_data.txt");
        pointTurnering.kampCyklus();
    }

}
