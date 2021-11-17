package Bordfodboldturnering;

import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        DBConnector db = new DBConnector();
        db.readFieldData();
       /* KnockOutTurnering turnering = new KnockOutTurnering();
        turnering.LæsFilData("SP3/resources/hold_data.txt");
        turnering.kampCyklus();
*/
    }

}
